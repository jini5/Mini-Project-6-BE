package com.mini.money.api;

import com.mini.money.entity.Loan;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Component
@RequiredArgsConstructor
public class PublicLoanApi {
    @Value("${api.auth}")
    private String auth;
    private final PublicLoanRepository publicLoanRepository;


    public void exampleApi() throws IOException, ParseException {
        for (int i = 841; i < 3649; i++) {

            // 1. URL을 만들기 위한 StringBuilder.
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1160100/service/GetSmallLoanFinanceInstituteInfoService/getOrdinaryFinanceInfo"); /*URL*/
            // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + auth); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + i); /*은행*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 넘버*/
            urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*페이지 넘버*/
            // 3. URL 객체 생성.
            URL url = new URL(urlBuilder.toString());
            // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 5. 통신을 위한 메소드 SET.
            conn.setRequestMethod("GET");
            // 6. 통신을 위한 Content-type SET.
            conn.setRequestProperty("Content-type", "application/json");
            // 7. 통신 응답 코드 확인.
            System.out.println("Response code: " + conn.getResponseCode());
            // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            // 10. 객체 해제.
            rd.close();
            conn.disconnect();
            // 11. 전달받은 데이터 확인.

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(sb.toString());

            JSONObject parseResult = (JSONObject) obj.get("response");
            JSONObject parseBody = (JSONObject) parseResult.get("body");
            JSONObject parseItems = (JSONObject) parseBody.get("items");
            JSONArray parseBaseList = (JSONArray) parseItems.get("item");

            JSONObject js = (JSONObject) parseBaseList.get(0);

            Loan publicLoan = new Loan(Long.valueOf(String.valueOf(js.get("snq"))), String.valueOf(js.get("basYm")), String.valueOf(js.get("finPrdNm")),
                    String.valueOf(js.get("lnLmt")), String.valueOf(js.get("irtCtg")), String.valueOf(js.get("irt")), String.valueOf(js.get("maxTotLnTrm")),
                    String.valueOf(js.get("maxDfrmTrm")), String.valueOf(js.get("maxRdptTrm")), String.valueOf(js.get("rdptMthd")),
                    String.valueOf(js.get("usge")), String.valueOf(js.get("trgt")), String.valueOf(js.get("instCtg")),
                    String.valueOf(js.get("ofrInstNm")), String.valueOf(js.get("rsdAreaPamtEqltIstm")), String.valueOf(js.get("suprTgtDtlCond")),
                    String.valueOf(js.get("age")), String.valueOf(js.get("incm")),
                    String.valueOf(js.get("crdtSc")), String.valueOf(js.get("grnInst")), String.valueOf(js.get("jnMthd")), String.valueOf(js.get("rpymdCfe")),
                    String.valueOf(js.get("lnIcdcst")), String.valueOf(js.get("ovItrYr")), String.valueOf(js.get("prftAddIrtCond")),
                    String.valueOf(js.get("etcRefSbjc")), String.valueOf(js.get("hdlInst")), String.valueOf(js.get("cnpl")),
                    String.valueOf(js.get("rltSite")), String.valueOf(js.get("prdNm")),
                    String.valueOf(js.get("mgmDln")), String.valueOf(js.get("prdCtg2")));


            publicLoanRepository.save(publicLoan);
        }
    }
}
