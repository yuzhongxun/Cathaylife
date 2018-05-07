package Maven.maven;

import com.google.gson.Gson;

class GsonTest{    
	@SuppressWarnings("unused")
	private String name;
    @SuppressWarnings("unused")
	private int age;
    
    public GsonTest(String string, int i) {
        this.name=string;
        this.age=i;
    }

    public static void main(String [] arge) {
       
        Gson gson = new Gson();
        GsonTest test_tojson = new GsonTest("你好",23);
        String jsonObject = gson.toJson(test_tojson); 
        System.out.println(jsonObject);
        
    }
}


