package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.RestClient;
import org.apache.wink.json4j.compat.JSONObject;


public class HttpClientHelper {
    public static final Logger logger = Logger.getLogger(HttpClientHelper.class);
 
    /**
     * @description 发送Http请求
     * @param request
     * @return
     */
    private static String sendRequest(HttpUriRequest request) {
        HttpClient client = new DefaultHttpClient();
        String line = null;
        StringBuffer sb = new StringBuffer();
        try {
            HttpResponse res = client.execute(request);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                InputStreamReader isr = new InputStreamReader(
                        entity.getContent(), HTTP.UTF_8);
                BufferedReader bufr = new BufferedReader(isr);// 缓冲
                while ((line = bufr.readLine()) != null) {
                    sb.append(line);
                }
                isr.close();
            }
        } catch (Exception e) {
            logger.error("HTTP服务存在异常，请检查http地址是否能访问！！", e);
            throw new RuntimeException(e);
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
        }
        return sb.toString();
    }
 
    /**
     * @description 向指定的URL发起一个put请求
     * @param uri
     * @param values
     * @return
     * @throws IOException
     */
    public static String doPut(String url, List<NameValuePair> values)
            throws IOException {
        HttpPut request = new HttpPut(url);
 
        if (values != null) {
            request.setEntity(new UrlEncodedFormEntity(values));
        }
        return sendRequest(request);
    }
 
    public static String doDelete(String url, Map<String,Object> params)
            throws IOException {
    	HttpDelete request = new HttpDelete(url); 
    	if (params != null && !params.isEmpty()) {        	
        	for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Object value=params.get(key);
				request.getParams().setParameter(key, value);
			}        	
        }
        return sendRequest(request);
    }
    /**
     * @description 向指定的URL发起一个GET请求并以String类型返回数据，获取数据总线数据
     * @param url
     * @return
     */
    public static String doGet(String url) {
        HttpGet request = new HttpGet(url);         
        return sendRequest(request);
    }
 
    /**
     * @description 向指定的URL发起一个post请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String doPost(String url, List<NameValuePair> values) throws IOException {
        HttpPost request = new HttpPost(url);
        if (values != null) {
            request.setEntity(new UrlEncodedFormEntity(values));
        }
        return sendRequest(request);
    }
 
    /**
     * REST请求POST方法
     * @param strUrl 请求的资源地址
     * @param params 请求的POST数据
     * @return string
     * @throws IOException
     */
    public static String restPost(String strUrl, Map params) throws IOException {
        if("".equals(strUrl)) return "0";
        String paramStr = "";
        URL url = new URL(strUrl);
        //实例一个http资源链接
        HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
        //设置链接的属性
        urlconn.setRequestMethod("POST");
        urlconn.setDoOutput(true);
        urlconn.setDoInput(true);
        urlconn.setUseCaches(false);
        urlconn.setAllowUserInteraction(false);
        urlconn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //实例一个输出流对象
        OutputStream outs = urlconn.getOutputStream();
        //实例一个Writer，并初始化
        Writer writer = new OutputStreamWriter(outs, "UTF-8");
        if(params.size() > 0){
            Iterator ups = params.entrySet().iterator();
            while (ups.hasNext()){
                Map.Entry upskv = (Map.Entry) ups.next();
                paramStr += upskv.getKey() + "=" + URLEncoder.encode(upskv.getValue().toString().trim(), "UTF-8") + "&";
            }
            paramStr = paramStr.substring(0, paramStr.length() - 1);
        }
        //写入字符串
        writer.write(paramStr);
        //结束Writer和OutputStream
        writer.close();
        outs.close();
        //获得请求的响应状态
        if(urlconn.getResponseCode() != 200){
            throw new IOException(urlconn.getResponseMessage());
        }
        //实例一个Buffer读取和字符串Builder
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
        StringBuilder  stringBuilder = new StringBuilder();
        String line;
        //将读取到的数据装载到line当中
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        bufferedReader.close();
        urlconn.disconnect();
        return stringBuilder.toString();
 
    }
    
	public void testRestClient(){    
		RestClient client = new RestClient();
		ClientResponse response = client.resource("http://example.com/resources/resource1")
				.header("Accept", "application/json;q=1.0, application/xml;q=0.8").get();
    // find what format was sent back
		String contentType = response.getHeaders().getFirst("Content-Type");
		if (contentType.contains("application/json")) {
			JSONObject entity = response.getEntity(JSONObject.class); /* or use a String, InputStream, or other
    	provider that supports the entity media type */
		} else if (contentType.contains("application/xml")) {
			String entity = response.getEntity(String.class); /* or use a JAXB class, InputStream, etc. */
		}
    }
	
	
	
  public static void main(String[] args) throws IOException {
	  Map<String,Object> map=new HashMap<String,Object>();
	  map.put("messge", "Hello!I am a get param");
        String str = HttpClientHelper
                .doGet("http://127.0.0.1:8080/test/rest/welcome?param=qqqqq");
        System.out.println(str);        
       
        String str2 = HttpClientHelper
                .doGet("http://127.0.0.1:8080/test/rest/welcome/a?name=xiaoming&orderby=name&orderby=age");
        System.out.println(str2);
        
        
        /*List<NameValuePair> values = new ArrayList<NameValuePair>();        
        values.add(new BasicNameValuePair("RequestMsg", "1")); 
        values.add(new BasicNameValuePair("test", "aaa"));
        String str2=HttpClientHelper
        		.doPost("http://127.0.0.1:8080/test/rest/helloworld",values);
        System.out.println(str2);*/
 
        /*String url = "http://127.0.0.1:8080/test/batchTfjFeedbackNotice.jsp";
        List<NameValuePair> values = new ArrayList<NameValuePair>();
 
        values.add(new BasicNameValuePair("RequestMsg", "1"));
 
        values.add(new BasicNameValuePair("test", "aaa"));
        try {
            HttpClientHelper.doPut(url, values);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
