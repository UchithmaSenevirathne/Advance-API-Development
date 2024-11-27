package lk.ijse.gdse68.introspringweb.controller;

import lk.ijse.gdse68.introspringweb.dto.Customer;
import lk.ijse.gdse68.introspringweb.dto.Item;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    @GetMapping("/pattern/{name}")
    public String healthCheck(@PathVariable ("name") String name){
        return "DemoController run perfectly " + name;
    }

    @GetMapping("/patternRegex/{id:C\\d{3}}")
    public String otherTest(@PathVariable ("id") String id){
        return "pattern regex " + id;
    }

    @GetMapping(value = "/patternRegex/{id:C\\d{3}}", headers = "X-number")
    public String pathVariableWithRegex(@PathVariable("id") String id, @RequestHeader("X-number") String num){
        return "Pathvariable " + id + " header " + num;
    }

    @GetMapping(params = "test=all")
    public String params(){
        return "all are tested";
    }

    @PostMapping(params= {"name", "quantity"})
    public String paramData(@RequestParam("name") String param01, @RequestParam("quantity") String param02){
        return "param data are " + param01 + " and " + param02;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveJSON(){
        return "Save JSON";
    }

    @PostMapping("/dynamic/{value:\\d{2}}")
    public ResponseEntity<String> returnDynamicData(@PathVariable("value") int value){
        if (value % 2 == 0){
            return ResponseEntity.ok("dynamic value is even");
        }
        return ResponseEntity.ok("dynamic value is odd");
    }

    @PostMapping(value = "/mapparams", params = {"id", "desc"})
    public String handleMaps(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam Map<String, String> params){
        System.out.println(params);
        return "handle maps with params " + params;
    }

    @PostMapping(value = "/multimapparams", params = {"id", "desc"})
    public String handleMultiMaps(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam MultiValueMap<String, String> params){
        System.out.println(params);
        return "handle maps with params " + params;
    }

    @PostMapping(value = "/multimapparamstodto", params = {"id","desc"})
    public String handleMultiMapsWithDTO(@RequestParam ("id") String id, @RequestParam ("desc")String desc, @RequestParam MultiValueMap<String,String> params, Item item){
        System.out.println(item);
        return "Handle Maps with params "+params;
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String JSONToDTO(@RequestBody Customer customer) {
        System.out.println(customer.getId());
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        return "convert success";
    }

}
