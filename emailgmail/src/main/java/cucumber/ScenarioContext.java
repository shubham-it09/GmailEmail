package cucumber;
 
import java.util.HashMap;
import java.util.Map;
import enums.GlobalData;;
 

//The purpose of this class is to get and set the global data that will be used in the execution flow
public class ScenarioContext {
 
 private  Map<String, Object> scenarioContext;
 
     public ScenarioContext(){
         scenarioContext = new HashMap<>();
     }
 
     public void setContext(GlobalData key, Object value) {
         scenarioContext.put(key.toString(), value);
     }
 
     public Object getContext(GlobalData key){
         return scenarioContext.get(key.toString());
     }
 
     public Boolean isContains(GlobalData key){
         return scenarioContext.containsKey(key.toString());
     }
     
    
     
     
     
}