package API.APIHelper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APICalls {

        @Test
        public void firstTestCase() {
            String url = "https://reqres.in/api/users?page=2";
            given()
                    .when()
                    .get(url)
                    .then()
                    .assertThat()
                    .statusCode(200);
        }

        @Test
        public void firstAPICall(){
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
            RequestSpecification httpRequest =  RestAssured.given();
            Response response = httpRequest.get();
            int statusCode = response.getStatusCode();
            System.out.println(statusCode);
            Assert.assertEquals("the status value is correct", 200,statusCode);

        }

        @Test
        public void secondAPICall() {
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get();
            String statusLine = response.getStatusLine();
            System.out.println(statusLine);
            Assert.assertEquals("the status line is correct", "HTTP/1.1 200 OK", statusLine);
        }

        @Test
        public void validateTheHeaders() {
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get();
            Headers allHeaders = response.headers();
            for(Header header : allHeaders){
                if(header.getName().equals("Content-Length")) {
                    System.out.println("Key: " + header.getName() + ", Value: " + header.getValue());
                }
            }
        }

        @Test
        public void validateIndividualHeader() {
            RestAssured.baseURI ="https://demoqa.com/BookStore/v1/Books";
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get();
            String getContentType = response.getHeader("Content-Type");
            System.out.println(getContentType);
        }

        @Test
        public void validateJSONBody() {
            RestAssured.baseURI = "https://reqres.in/api/users?page=2";
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get();
            ResponseBody responseBody = response.getBody();
            String responseBodyInString = responseBody.asString();
            System.out.println(responseBodyInString);
            Assert.assertTrue(responseBodyInString.contains("page"));
            Assert.assertTrue(responseBodyInString.contains("per_page"));
            JsonPath jsonPathEvaluator = response.jsonPath();
            String jsonNode = jsonPathEvaluator.get("per_page");
            System.out.println(jsonNode);
        }

        @Test
        public void makePostRequest() {
            RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
            RequestSpecification httpRequest = RestAssured.given();
            JSONObject requestParams = new JSONObject();
            requestParams.put("userId", "TQ123");
            requestParams.put("isbn", "9781449325862");
            Response response = httpRequest.put("/User");
            ResponseBody responseBody = response.getBody();
            System.out.println(response.getStatusLine());
            System.out.println(responseBody.asString());
        }

    }
