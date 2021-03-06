USE [cmia]
GO
/****** Object:  Table [dbo].[sys_user]    Script Date: 03/12/2014 17:27:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sys_user](
	[id] [varchar](50) NOT NULL,
	[loginName] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[name] [varchar](50) NOT NULL,
	[active] [varchar](5) NULL,
	[order] [int] NULL,
	[cppccUnit] [varchar](50) NOT NULL,
	[level] [varchar](50) NULL,
 CONSTRAINT [PK_sys_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
