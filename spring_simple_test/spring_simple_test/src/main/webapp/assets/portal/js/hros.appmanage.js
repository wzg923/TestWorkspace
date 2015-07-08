/*
**  全局视图
*/
HROS.appmanage = (function(){
	return {
		init : function(){
			$('#amg_dock_container').html('').append($('#dock-container .dock-applist li').clone());
			$('#desk .desktop-container').each(function(i){
				var index = $(this).attr("id").split("-")[1];
				
				$('#amg_folder_container .folderItem:eq(' + (index-1) + ') .folderInner').html('');
				$(this).children('.appbtn:not(.add)').each(function(){
					$('#amg_folder_container .folderItem:eq(' + (index-1) + ') .folderInner').append($(this).clone());
				});
			});
			$('#desktop').hide();
			$('#appmanage').show();
			$('#amg_folder_container .folderItem').show().addClass('folderItem_turn');
			$('#amg_folder_container').height($(document).height() - 80);
			$('#appmanage .amg_close').off('click').on('click', function(){
				HROS.appmanage.close();
			});
			$(".folderItem").css({width:((100/HROS.CONFIG.deskLength)+'%')});
			HROS.appmanage.appresize();
			HROS.appmanage.move();
			HROS.appmanage.getScrollbar();
			HROS.appmanage.moveScrollbar();
		},
		getScrollbar : function(){
			setTimeout(function(){
				$('#amg_folder_container .folderItem').each(function(){
					var desk = $(this).find('.folderInner'), deskrealh = parseInt(desk.children('.appbtn:last').css('top')) + 41, scrollbar = desk.next('.scrollBar');
					//先清空所有附加样式
					scrollbar.hide();
					desk.scrollTop(0);
					if(desk.height() / deskrealh < 1){
						scrollbar.height(desk.height() / deskrealh * desk.height()).css('top', 0).show();
					}
				});
			},500);
		},
		moveScrollbar : function(){
			/*
			**  手动拖动
			*/
			$('.scrollBar').on('mousedown', function(e){
				var y, cy, deskrealh, moveh;
				var scrollbar = $(this), desk = scrollbar.prev('.folderInner');
				deskrealh = parseInt(desk.children('.appbtn:last').css('top')) + 41;
				moveh = desk.height() - scrollbar.height();
				y = e.clientY - scrollbar.offset().top;
				$(document).on('mousemove', function(e){
					//减80px是因为顶部dock区域的高度为80px，所以计算移动距离需要先减去80px
					cy = e.clientY - y - 80 < 0 ? 0 : e.clientY - y - 80 > moveh ? moveh : e.clientY - y - 80;
					scrollbar.css('top', cy);
					desk.scrollTop(cy / desk.height() * deskrealh);
				}).on('mouseup', function(){
					$(this).off('mousemove').off('mouseup');
				});
			});
			/*
			**  鼠标滚轮
			*/
			$('#amg_folder_container .folderInner').off('mousewheel').on('mousewheel', function(event, delta){
				var desk = $(this), deskrealh = parseInt(desk.children('.appbtn:last').css('top')) + 41, scrollupdown;
				/*
				**  delta == -1   往下
				**  delta == 1    往上
				*/
				if(delta < 0){
					scrollupdown = desk.scrollTop() + 120 > deskrealh - desk.height() ? deskrealh - desk.height() : desk.scrollTop() + 120;
				}else{
					scrollupdown = desk.scrollTop() - 120 < 0 ? 0 : desk.scrollTop() - 120;
				}
				desk.stop(false, true).animate({
					scrollTop : scrollupdown
				}, 300);
				desk.next('.scrollBar').stop(false, true).animate({
					top : scrollupdown / deskrealh * desk.height()
				}, 300);
			});
		},
		resize : function(){
			$('#amg_folder_container').height($(document).height() - 80);
			HROS.appmanage.getScrollbar();
		},
		appresize : function(){
			var manageDockGrid = HROS.grid.getManageDockAppGrid();
			$('#amg_dock_container li').each(function(i){
				$(this).css({
					'left' : manageDockGrid[i]['startX'],
					'top' : 10
				});
			});
			for(var i = 0; i < 7; i++){
				var manageAppGrid = HROS.grid.getManageAppGrid();
				$('#amg_folder_container .folderItem:eq(' + i + ') .folderInner li').each(function(j){
					$(this).css({
						'left' : 0,
						'top' : manageAppGrid[j]['startY']
					}).attr('desk', i);
				});
			}
		},
		close : function(){
			$('#amg_dock_container').html('');
			$('#amg_folder_container .folderInner').html('');
			$('#desktop').show();
			$('#appmanage').hide();
			$('#amg_folder_container .folderItem').removeClass('folderItem_turn');
			HROS.app.get();
		},
		move : function(){
			//应用全景图中禁用dock拖动
			/*$('#amg_dock_container').off('mousedown').on('mousedown', 'li', function(e){
				e.preventDefault();
				e.stopPropagation();
				if(e.button == 0 || e.button == 1){
					var oldobj = $(this), x, y, cx, cy, dx, dy, lay, obj = $('<li id="shortcut_shadow">' + oldobj.html() + '</li>');
					dx = cx = e.clientX;
					dy = cy = e.clientY;
					x = dx - oldobj.offset().left;
					y = dy - oldobj.offset().top;
					//绑定鼠标移动事件
					$(document).on('mousemove', function(e){
						$('body').append(obj);
						lay = HROS.maskBox.desk();
						lay.show();
						cx = e.clientX <= 0 ? 0 : e.clientX >= $(document).width() ? $(document).width() : e.clientX;
						cy = e.clientY <= 0 ? 0 : e.clientY >= $(document).height() ? $(document).height() : e.clientY;
						_l = cx - x;
						_t = cy - y;
						if(dx != cx || dy != cy){
							obj.css({
								left : _l,
								top : _t
							}).show();
						}
					}).on('mouseup', function(){
						$(document).off('mousemove').off('mouseup');
						obj.remove();
						if(typeof(lay) !== 'undefined'){
							lay.hide();
						}
						//判断是否移动图标，如果没有则判断为click事件
						if(dx == cx && dy == cy){
							HROS.appmanage.close();
							switch(oldobj.attr('type')){
								case 'widget':
								case 'pwidget':
									HROS.widget.create(oldobj.attr('appid'));
									break;
								case 'app':
								case 'papp':
								case 'folder':
									HROS.window.create(oldobj.attr('appid'));
									break;
							}
							return false;
						}
						var icon, icon2;
						if(cy <= 80){
							var appLength = $('#amg_dock_container li').length - 1;
							icon2 = HROS.grid.searchManageDockAppGrid(cx);
							if(icon2 != oldobj.index() && icon2 - 1 != oldobj.index()){
								$.ajax({
									type : 'POST',
									url : HROS.CONFIG.basicActionUrl+'/updateMyApp.action',
									data : 'movetype=dock-dock&id=' + oldobj.attr('appid') + '&from=' + oldobj.index() + '&to=' + icon2 + '&desk=' + HROS.CONFIG.desk,
									success : function(){
										if(icon2 > appLength){
											$('#amg_dock_container li:eq(' + appLength + ')').after(oldobj);
										}else{
											$('#amg_dock_container li:eq(' + icon2 + ')').before(oldobj);
										}
										HROS.appmanage.appresize();
										HROS.appmanage.getScrollbar();
									}
								});
							}
						}else{
							var movedesk = parseInt(cx / ($(document).width() / HROS.CONFIG.deskLength));
							var appLength = $('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li').length - 1;
							icon = HROS.grid.searchManageAppGrid(cy - 80);
							$.ajax({
								type : 'POST',
								url : HROS.CONFIG.basicActionUrl+'/updateMyApp.action',
								data : 'movetype=dock-desk&id=' + oldobj.attr('appid') + '&from=' + oldobj.index() + '&to=' + (icon + 1) + '&desk=' + (movedesk + 1),
								success : function(){
									//判断目标桌面列表是否为空
									if(appLength == -1){
										$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner').append(oldobj);
									}else{
										if(icon > appLength){
											$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + appLength + ')').after(oldobj);
										}else{
											$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + icon + ')').before(oldobj);
										}
									}
									HROS.appmanage.appresize();
									HROS.appmanage.getScrollbar();
								}
							});
						}
					});
				}
				return false;
			});*/
			$('#amg_folder_container').off('mousedown', 'li.appbtn:not(.add)').on('mousedown', 'li.appbtn:not(.add)', function(e){
				e.preventDefault();
				e.stopPropagation();
				if(e.button == 0 || e.button == 1){
					var oldobj = $(this), x, y, cx, cy, dx, dy, lay, obj = $('<li id="shortcut_shadow2">' + oldobj.html() + '</li>');
					dx = cx = e.clientX;
					dy = cy = e.clientY;
					x = dx - oldobj.offset().left;
					y = dy - oldobj.offset().top;
					//绑定鼠标移动事件
					$(document).on('mousemove', function(e){
						$('body').append(obj);
						lay = HROS.maskBox.desk();
						lay.show();
						cx = e.clientX <= 0 ? 0 : e.clientX >= $(document).width() ? $(document).width() : e.clientX;
						cy = e.clientY <= 0 ? 0 : e.clientY >= $(document).height() ? $(document).height() : e.clientY;
						_l = cx - x;
						_t = cy - y;
						if(dx != cx || dy != cy){
							obj.css({left:_l, top:_t}).show();
						}
					}).on('mouseup', function(){
						$(document).off('mousemove').off('mouseup');
						obj.remove();
						if(typeof(lay) !== 'undefined'){
							lay.hide();
						}
						//判断是否移动图标，如果没有则判断为click事件
						if(dx == cx && dy == cy){
							HROS.appmanage.close();
							switch(oldobj.attr('type')){
								case 'widget':
								case 'pwidget':
									HROS.widget.create(oldobj.attr('appid'));
									break;
								case 'app':
								case 'papp':
								case 'folder':
									HROS.window.create(oldobj.attr('appid'));
									break;
							}
							return false;
						}
						var icon, icon2;
						if(cy <= 80){
							//应用全景图中禁用dock拖动
							/*var appLength = $('#amg_dock_container li').length - 1;
							icon2 = HROS.grid.searchManageDockAppGrid(cx);
							$.ajax({
								type : 'POST',
								url : HROS.CONFIG.basicActionUrl+'/updateMyApp.action',
								data : 'movetype=desk-dock&id=' + oldobj.attr('appid') + '&from=' + oldobj.index() + '&to=' + (icon2 + 1) + '&desk=' + (parseInt(oldobj.attr('desk')) + 1),
								success : function(){
									if(appLength == -1){
										$('#amg_dock_container').append(oldobj);
									}else{
										if(icon2 > appLength){
											$('#amg_dock_container li:eq(' + appLength + ')').after(oldobj);
										}else{
											$('#amg_dock_container li:eq(' + icon2 + ')').before(oldobj);
										}
									}
									if($('#amg_dock_container li.appbtn').length > 7){
										if($('#amg_folder_container .folderItem:eq(' + oldobj.attr('desk') + ') .folderInner li').length == 0){
											$('#amg_folder_container .folderItem:eq(' + oldobj.attr('desk') + ') .folderInner').append($('#amg_dock_container li').last());
										}else{
											$('#amg_folder_container .folderItem:eq(' + oldobj.attr('desk') + ') .folderInner li').last().after($('#amg_dock_container li').last());
										}
									}
									HROS.appmanage.appresize();
									HROS.appmanage.getScrollbar();
								}
							});*/
						}else{
							var movedesk = parseInt(cx / ($(document).width() / HROS.CONFIG.deskLength));
							var appLength = $('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li').length - 1;
							icon = HROS.grid.searchManageAppGrid(cy - 80);
							//判断是在同一桌面移动，还是跨桌面移动
							if(movedesk == oldobj.attr('desk')){
								if(icon != oldobj.index() && icon - 1 != oldobj.index()){
									$.ajax({
										type : 'POST',
										url : HROS.CONFIG.basicActionUrl+'/updateMyApp.action',
										data : 'movetype=desk-desk&id=' + oldobj.attr('appid') + '&from=' + oldobj.index() + '&to=' + icon + '&desk=' + (movedesk + 1),
										success : function(){
											if(icon > appLength){
												$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + appLength + ')').after(oldobj);
											}else{
												$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + icon + ')').before(oldobj);
											}
											HROS.appmanage.appresize();
											HROS.appmanage.getScrollbar();
										}
									});
								}
							}else{
								$.ajax({
									type : 'POST',
									url : HROS.CONFIG.basicActionUrl+'/updateMyApp.action',
									data : 'movetype=desk-otherdesk&id=' + oldobj.attr('appid') + '&from=' + oldobj.index() + '&to=' + icon + '&desk=' + (parseInt(oldobj.attr('desk')) + 1) + '&otherdesk=' + (movedesk + 1),
									success : function(){
										//判断目标桌面列表是否为空
										if(appLength == -1){
											$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner').append(oldobj);
										}else{
											if(icon > appLength){
												$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + appLength + ')').after(oldobj);
											}else{
												$('#amg_folder_container .folderItem:eq(' + movedesk + ') .folderInner li:eq(' + icon + ')').before(oldobj);
											}
										}
										HROS.appmanage.appresize();
										HROS.appmanage.getScrollbar();
									}
								});
							}
						}
					});
				}
				return false;
			});
		}
	}
})();