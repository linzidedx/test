
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath; 

public class JavaPostJson2 {
    final static String url = "http://wmc-gateway.stage.yunshanmeicai.com/api_adapt/wmcMasterAdmin/com.sprucetec.wmc.master.admin.spi.SsuService/queryByIds";
    final static String params = "[[3706]]";

    public static void main1(String[] args) {

        String res = post(url, params);
        System.out.println(res);
//        try {
//			//�ַ���ת��JSON����
//			//JSONArray jsonarry = new JSONArray(res);
//			//����JSON����
//			if(jsonarry.length() > 0){
//				for (int i = 0;i < jsonarry.length();i++) {
//					//���json����
//					JSONObject  jsonObject = jsonarry.getJSONObject(i);
//					//����key��ȡֵ
//					System.err.println(jsonObject.getString("shuxue"));
//				}
//			}
//		    
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

    }

    /**
     * ����HttpPost����
     * 
     * @param strURL
     *            �����ַ
     * @param params
     *            json�ַ���,����: "{ \"id\":\"12345\" }" ;���������������˫����<br/>
     * @return �ɹ�:����json�ַ���<br/>
     */
    public static String post(String strURL, String params) {
        System.out.println(strURL);
        System.out.println(params);
        BufferedReader reader = null;
        try {
            URL url = new URL(strURL);// ��������
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // ��������ʽ
            // connection.setRequestProperty("Accept", "application/json"); // ���ý������ݵĸ�ʽ
            connection.setRequestProperty("Content-Type", "application/json"); // ���÷������ݵĸ�ʽ
            connection.connect();
            //һ��Ҫ��BufferedReader ��������Ӧ�� ʹ���ֽ���������Ӧ�ķ����ǽ��ղ������ݵ�
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8����
            out.append(params);
            out.flush();
            out.close();
            // ��ȡ��Ӧ
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
            	System.out.println("1"+line);
                res += line;
            }
            reader.close();
            
            //���һ��Ҫʹ�����·�ʽ������Ӧ���ݣ� ����Ӧ����Ϊ: response.getWriter().print(StringUtils.join("{\"errCode\":\"1\",\"errMsg\":\"", message, "\"}")); ������
//            int length = (int) connection.getContentLength();// ��ȡ����
//            if (length != -1) {
//                byte[] data = new byte[length];
//                byte[] temp = new byte[512];
//                int readLen = 0;
//                int destPos = 0;
//                while ((readLen = is.read(temp)) > 0) {
//                    System.arraycopy(temp, 0, data, destPos, readLen);
//                    destPos += readLen;
//                }
//                String result = new String(data, "UTF-8"); // utf-8����
//                System.out.println(result);
//                return result;
//            }

            return res;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error"; // �Զ��������Ϣ
    }

}

