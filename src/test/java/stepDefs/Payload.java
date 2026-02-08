package stepDefs;//package stepDefs;
//
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;`
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Payload {
//
//    RequestSpecification requestSpecification;
//
//    public static String getValue(JsonPath jsonPath, String objectPath, String key) {
//        Map<String, Object> map = jsonPath.getMap(objectPath);
////        return map != null && map.containsKey(key);
//        return map.get(key).toString();
//    }
//
//    @Test
//    public void testCase01() {
//        Map<String, String> map = new HashMap<>();
//        map.put("username", "admin");
//        map.put("password", "password123");
//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com")
//                .basePath("/auth")
//                .header("Content-type", "application/json")
//                .contentType(ContentType.JSON)
//                .body(map);
//
//        Response response = requestSpecification.post();
//        System.out.println(response.getBody().asString());
//    }
//
//    @Test
//    public void testCase02() {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map1 = new HashMap<>();
//        map.put("firstname", "Jim");
//        map.put("lastname", "Brown");
//        map.put("totalprice", 111);
//        map.put("depositpaid", true);
//        map.put("additionalneeds", "Breakfast");
//        map1.put("checkin", "2018-01-01");
//        map1.put("checkout", "2019-01-01");
//        map.put("bookingdates", map1);
//
//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com")
//                .basePath("/booking")
//                .header("Content-type", "application/json")
//                .contentType(ContentType.JSON)
//                .body(map);
//        Response response = requestSpecification.post();
//        response.prettyPrint();
//    }
//   static int x;
//    Payload(int x){
//        Payload.x += 1;
//    }
//    Payload(){
//        this(4);
//    }
//     void eat(){
//
//    }
//    public static void main(String[] args) {
//        Payload payload= new Payload();
//        payload.eat();
//        System.out.println("x:"+payload.x);
//        Payload payload1= new Payload();
//        System.out.println("x:"+payload1.x);
//        ArrayList<Integer> a = new ArrayList<>();
//
//        a.add(1);
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(3);
//        a.add(4);
//        a.add(4);
//        a.add(5);
//
//        ArrayList<Integer> al = new ArrayList<>();
//        System.out.println(a);
//
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int count = 0;
//
//        for (int i = 0; i < a.size(); i++) {
//            int x = a.get(i);
//            for (int j = i + 1; j < a.size(); j++) {
//                int y = a.get(j);
//                if (x == y) {
//                    a.remove(j);
//                }
//            }
//            System.out.println(a);
//
//        }
//
//
//        System.out.println(a);
//    }
//
//}
