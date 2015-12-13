//package br.gms.wsvaleuboi.rest.providers;
//
//import javax.ws.rs.Produces;
//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;
//
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.SerializationConfig.Feature;
//
//
//@Provider
//@Produces("application/json")
//public class MyJacksonProvider implements ContextResolver<ObjectMapper> 
//{
//    private final ObjectMapper mapper;
//
//    public MyJacksonProvider() 
//    {
//        mapper = new ObjectMapper();
//        mapper.disable(Feature.FAIL_ON_EMPTY_BEANS);
//    }
//
//    @Override
//    public ObjectMapper getContext(Class<?> type) 
//    {
//        return mapper;
//    }
//}