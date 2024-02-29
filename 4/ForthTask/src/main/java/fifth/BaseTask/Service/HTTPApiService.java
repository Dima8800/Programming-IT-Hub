package fifth.BaseTask.Service;

import fifth.BaseTask.Models.Request;
import fifth.BaseTask.Models.ServeResponse;
import fifth.BaseTask.Models.TimeResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPApiService {
    String link = "http://10.3.0.96:8000/api/w4/";
    int push = 0;
    int get = 0;
    String id = "i22s0623";

    public boolean finished(){
        try {
            String url = link + ("total");
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            String urlParameters = Integer.toString(push);

            con.setDoOutput(true);
            con.setRequestProperty("Stud-ID", id);
            con.setRequestProperty("Content-Type", "text/plain");

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

            if (response.toString().equals("правильно"))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }
    public void pushTime(TimeResponse resp){
        try {
            System.out.println(resp);
            String url = link + (push);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");

            String urlParameters = resp.toString();
            con.setDoOutput(true);
            con.setRequestProperty("Stud-ID", id);
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

            if ("неправильно".equals(response.toString())) {
                System.out.println(response.toString());
            }
            push++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pushServe(ServeResponse resp){
        try {
            System.out.println(resp);
            String url = link + (push);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");

            String urlParameters = resp.toString();
            con.setDoOutput(true);
            con.setRequestProperty("Stud-ID", id);
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

            if ("неправильно".equals(response.toString())) {
                System.out.println(response.toString());
            }
            push++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Request GetNext(){
        try {
            URL url = new URL(link + get);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Stud-ID", id);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("\n Response: " + response.toString());
            connection.disconnect();

            get++;

            Request r = new Request(response.toString());

            return r.getRequest();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
