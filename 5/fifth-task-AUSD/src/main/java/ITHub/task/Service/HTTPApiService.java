package ITHub.task.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPApiService {
    private final String studID;
    private static String link;
    public HTTPApiService(String studID, String link){
        this.studID = studID;
        this.link = link;
    }
    public String getActivity(){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Stud-ID", studID);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
    public boolean postAnal(String json){
        try {
            URL obj = new URL(link);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            String urlParameters = json;

            con.setDoOutput(true);
            con.setRequestProperty("Stud-ID", studID);
            con.setRequestProperty("Content-Type", "application/json");

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);

            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ошибка отправки");
        return false;
    }
}
