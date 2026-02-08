package stepDefs;//package stepDefs;//package stepDefs;
//
//import static io.restassured.RestAssured.*;
//
//import PojoClasses.DeserializePOJO;
//import PojoClasses.PayloadPOJO;
//import PojoFactory.HostlersDetails;
//import PojoFactory.StudentDetails;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.http.Header;
//import io.restassured.http.Headers;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.QueryableRequestSpecification;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.SpecificationQuerier;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.io.File;
//import java.util.*;
//
//public class httpRequest {
//    RequestSpecification requestSpecification;
//
//    public static String getValue(JsonPath jsonPath, String objectPath, String key) {
//        Map<String, Object> map = jsonPath.getMap(objectPath);
////        return map != null && map.containsKey(key);
//        return map.get(key).toString();
//    }
//    public static <T> T getResponse(Response res, String path) {
//        return res.jsonPath().get(path);
//    }
//
//
//    @Test
//    public void testCase01() throws JsonProcessingException {
//        Response response = get("http://localhost:3000/headers");
//        JsonPath jsonPath = response.jsonPath();
////        List<List<Map<String, Integer>>> list = jsonPath.getList("orders.items");
//        System.out.println(response.getBody().asString());
//
//         ObjectMapper objectMapper = new ObjectMapper();
////         List<StudentDetails> studentDetails = objectMapper.readValue(response.getBody().asString(), new TypeReference<List<StudentDetails>>() {});
//         List<HostlersDetails> hostlersDetails = objectMapper.readValue(response.getBody().asString(), new TypeReference<List<HostlersDetails>>() {});
//        System.out.println(jsonPath.getList("address.dist"));
//
//        hostlersDetails.forEach(student ->{
//           System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+(student.getAddress()!=null ? student.getAddress().getDist() : "")+" "+(student.getAddress()!=null ? student.getAddress().getState() : ""));
//       } );
//
//
//
//
//       /*
//       given()
//       .when()
//       .get("/students")
//       .then()
//       .extract()
//       .as(new TypeReference<List<StudentDetails>>() {});
//    */
//    }
//
//
////
////    @Test
////    public void testCase02() {
////        baseURI = "https://reqres.in";
////        given()
////                .queryParam("page", "2")
////                .when()
////                .get("/api/users")
////                .then()
////                .statusCode(200);
////    }
////
////    @Test
////    public void testCase03() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("title", "foo");
////        jsonObject.put("body", "bar");
////        jsonObject.put("userId", 1);
////        given()
////                .header("Content-type", "application/json")
////                .contentType(ContentType.JSON)
////                .body(jsonObject.toJSONString())
////                .when()
////                .post()
////                .then()
////                .log().body()
////                .statusCode(201);
////    }
////
////    @Test
////    public void testCase04() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("title", "foo1");
////        jsonObject.put("body", "bar1");
////        jsonObject.put("userId", 102);
////        given()
////                .header("Content-type", "application/json")
////                .contentType(ContentType.JSON)
////                .body(jsonObject.toJSONString())
////                .when()
////                .put()
////                .then()
////                .log().body()
////                .statusCode(200);
////    }
////
////    @Test
////    public void testCase05() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("title", "foo1");
////        given()
////                .header("Content-type", "application/json")
////                .contentType(ContentType.JSON)
////                .body(jsonObject.toJSONString())
////                .when()
////                .patch()
////                .then()
////                .log().body()
////                .statusCode(200);
////    }
////
////    @Test
////    public void testCase06() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
////        given()
////                .when()
////                .delete()
////                .then()
////                .log().body()
////                .statusCode(200);
////    }
////
////    @Test
////    public void testCase07() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
////        requestSpecification = RestAssured.given();
////        Response response = requestSpecification.get();
////        System.out.println(response.statusCode());
////    }
////
////    @Test
////    public void testCase08() {
////        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
////        requestSpecification = RestAssured.given();
////        Response response = requestSpecification.get();
////        ValidatableResponse validatableResponse = response.then();
////        validatableResponse.statusCode(200);
////    }
////
////    @Test
////    public void testCase09() {
////
////        given()
////                .when()
////                .get("https://jsonplaceholder.typicode.com/posts/1")
////                .then()
////                .statusCode(200);
////
////    }
////
////    @Test
////    public void testCase10() {
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
////        requestSpecification.basePath("/posts/1");
////        Response response = requestSpecification.get();
////        Headers headers = response.headers();
////
////        for (Header header : headers) {
////            System.out.println(header.getValue());
////        }
////    }
////
////    @Test
////    public void testCase11() {
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
////        requestSpecification.basePath("/comments");
////        requestSpecification.queryParam("postId", 1).queryParam("id", 1);
////        Response response = requestSpecification.get();
////        System.out.println(response.getBody().asString());
////        JsonPath jsonPath = response.jsonPath();
////        List<Map<String, Object>> list = jsonPath.getList("$");
////        Assert.assertTrue(list.get(0).containsKey("email"));
////    }
////
////    @Test
////    public void testCase12() {
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://postman-echo.com");
////        requestSpecification.basePath("/basic-auth");
////        Response response = requestSpecification.auth().basic("postman", "password").get();
////        System.out.println(response.getBody().asString());
////    }
////
////    @Test
////    public void testCase13() {
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://httpbin.org");
////        requestSpecification.basePath("/digest-auth/undefined/user/password/MD5");
////        Response response = requestSpecification.auth().digest("user", "password").get();
////        System.out.println(response.getBody().asString());
////    }
////
////    @Test
////    public void testCase14() {
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://httpbin.org");
////        requestSpecification.basePath("/digest-auth/undefined/user/password/MD5");
////        Response response = requestSpecification.auth().digest("user", "password").get();
////        System.out.println(response.getBody().asString());
////    }
////
////    @Test
////    public void testCase15() {
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("title", "foo1");
////        jsonObject.put("body", "bar1");
////        jsonObject.put("userId", 102);
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
////        requestSpecification.basePath("/posts");
////        requestSpecification.header("Content-type", "application/json");
////        requestSpecification.contentType(ContentType.JSON);
////        requestSpecification.body(jsonObject.toJSONString());
////        Response response = requestSpecification.post();
////        System.out.println(response.getBody().asString());
////        DeserializePOJO deserializePOJO = response.body().as(DeserializePOJO.class);
////        System.out.println(deserializePOJO.getBody());
////    }
////    @Test
////    public void testCase16() {
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("title", "foo1");
////        jsonObject.put("body", "bar1");
////        jsonObject.put("userId", 102);
////        requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://jsonplaceholder.typicode.com")
////        .basePath("/posts")
////        .header("Content-type", "application/json")
////        .contentType(ContentType.JSON)
////        .body(jsonObject.toJSONString());
////
////        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
////        System.out.println(queryableRequestSpecification.getBaseUri());
////        System.out.println(queryableRequestSpecification.getBody().toString());
////        System.out.println(queryableRequestSpecification.getHeaders().toString());
////        System.out.println(queryableRequestSpecification.getBasePath());
////
////    }
////
////    @Test
////    public void testCase17() {
////        requestSpecification = RestAssured.given();
////       Response response = requestSpecification.baseUri("https://httpbin.org")
////        .basePath("/post").contentType("multipart/form-data")
////        .multiPart(new File("C:\\Users\\HP\\OneDrive\\Desktop\\TestFile.txt")).post();
////        response.body().prettyPrint();
////    }
////    @Test
////    public void testCase18() {
////        requestSpecification = RestAssured.given();
////       Response response = requestSpecification.baseUri("http://localhost:3000")
////        .basePath("/headers")
////        .get();
////        response.body().prettyPrint();
////    }
////    @Test
////    public void testCase19() {
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("Name", "gchgcv");
////        jsonObject.put("Age", 28);
////        requestSpecification = RestAssured.given();
////       Response response = requestSpecification.baseUri("http://localhost:3000")
////        .basePath("/headers")
////               .body(jsonObject.toJSONString())
////        .post();
////        response.body().prettyPrint();
////    }
////    @Test
////    public void testCase20() throws JsonProcessingException {
////        PayloadPOJO payloadPOJO = new PayloadPOJO();
////        payloadPOJO.setUsername("jsbakjsabi");
////        payloadPOJO.setPassword("jsbakjsabi");
////
////        ObjectMapper objectMapper = new ObjectMapper();
////        String payloadJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadPOJO);
////        System.out.println(payloadJson);
////
////        PayloadPOJO payloadPOJO1 = objectMapper.readValue(payloadJson,PayloadPOJO.class);
////        System.out.println(payloadPOJO1.getPassword());
////    }
////
////    @Test
////    public void testCase21() throws JsonProcessingException {
////        PayloadPOJO payloadPOJO = new PayloadPOJO();
////        payloadPOJO.setUsername("jsbakjsabi");
////        payloadPOJO.setPassword("jsbakjsabi");
////        PayloadPOJO payloadPOJO2 = new PayloadPOJO();
////        payloadPOJO2.setUsername("jsbakjsabi");
////        payloadPOJO2.setPassword("jsbakjsabi");
////        List<PayloadPOJO> list = new ArrayList<>();
////        list.add(payloadPOJO);
////        list.add(payloadPOJO2);
////
////        ObjectMapper objectMapper = new ObjectMapper();
////        String payloadJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
////        System.out.println(payloadJson);
////
////
////        List<PayloadPOJO> list1 =objectMapper.readValue(payloadJson,  new TypeReference<List<PayloadPOJO>>() {});
////        System.out.println(list1.get(0).getPassword());
////    }
////    @Test
////    public void testCase22() throws JsonProcessingException {
////
////        Map<String, Object> header = new HashMap<>();
////        header.put("sakjbkjas","kasjolks");
////        header.put("sakjbkjas1","kasjolks1");
////
////        requestSpecification = RestAssured.given();
////        Response response = requestSpecification.baseUri("https://jsonplaceholder.typicode.com/posts/1")
////                .basePath("/headers")
////                .headers(header)
////                .log()
////                .all()
////                .get().then().log().body().extract().response();
////
////        response.body().prettyPrint();
////
////    }
//}
