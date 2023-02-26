//package com.springdemo.helloworld.es;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.springdemo.helloworld.dto.CourseDTO;
//import com.springdemo.helloworld.repository.CoursesRepository;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
//import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
//import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.client.indices.GetIndexResponse;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.index.query.TermQueryBuilder;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.rmi.server.ExportException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class RestESClient {
//
//    final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//
//    @Autowired
//    private CoursesRepository coursesRepository;
//
//
//    @PostConstruct
//    public RestHighLevelClient intiate(){
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("localhost", 9200, "http")));
////        SearchRequest searchRequest = new SearchRequest();
////
////        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
////
////        BoolQueryBuilder qb =
//        GetIndexRequest existingIndex = new GetIndexRequest("alexakis_magkas");
//        boolean exists = false ;
//        try {
//            exists = client.indices().exists(existingIndex, RequestOptions.DEFAULT);
//
//
//        if(!exists){
//
//            DeleteIndexRequest deleteRequest = new DeleteIndexRequest("alexakis_magkas");
//            client.indices().delete(deleteRequest, RequestOptions.DEFAULT);
//
//            CreateIndexRequest request = new CreateIndexRequest("alexakis_magkas");
//            request.settings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 2));
//
//            CreateIndexResponse createIndexResponse = null;
//            try {
//                createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            System.out.println("response id: " + createIndexResponse.index());
//            return client;
//
//        }
//
////        GetIndexRequest exampleIndex = new GetIndexRequest("sampleindex1");
////        GetIndexResponse getIndexResponse = client.indices().get(existingIndex,RequestOptions.DEFAULT);
////        GetIndexResponse getIndexResponseForExample = client.indices().get(exampleIndex,RequestOptions.DEFAULT);
////        getIndexResponse.getAliases().get("alexakis_magkas");
////        getIndexResponseForExample.getAliases().get("sampleindex1");
//        IndexRequest indexRequest = new IndexRequest("alexakis_magkas");
////        indexRequest.id("000000234");
//        indexRequest.source("SampleKey","SampleValue");
////        IndexResponse indexResponse = null;
////        try {
////            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        System.out.println("response id: "+indexResponse.getId());
////        System.out.println("response name: "+indexResponse.getResult().name());
//
////        HashMap<String, Integer> map = new HashMap<String, Integer>();
////        map.put("keyOne", 10);
////        map.put("keyTwo", 30);
////        map.put("KeyThree", 20);
////
////        IndexRequest indexRequest = new IndexRequest("sampleindex1");
////        indexRequest.id("002");
////        indexRequest.source(map);
////        IndexResponse indexResponse = null;
////        try {
////            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        System.out.println("response id: "+indexResponse.getId());
////        System.out.println("response name: "+indexResponse.getResult().name());
////
////        EmployeePojo emp = new EmployeePojo("AlexandrosASD", "LozisDSAD","NO_IDEA");
//        CourseDTO emp = new CourseDTO("213214213412","Alexandros", ",MATH","19");
//            IndexResponse indexResponse = null;
//            List<CourseDTO> allUsers = coursesRepository.findAll().stream().map(course -> new CourseDTO(course.getId(),course.getName(),course.getType(),course.getGrade())).collect(Collectors.toList());
//            int id = 0;
//            for (CourseDTO allUser : allUsers) {
//                indexRequest.id(allUser.getId());
//                indexRequest.source(new ObjectMapper().writeValueAsString(allUser), XContentType.JSON);
//                indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
//                id++;
//            }
//
//            BoolQueryBuilder query = QueryBuilders.boolQuery();
//            QueryBuilder filter = QueryBuilders.matchQuery("name","T");
//            query.should(filter);
////            filter.must(QueryBuilders.termQuery("name","Takis"));
//
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
//                    .query(query)
//                            .size(500)
//                             .postFilter(filter);
//
//            SearchRequest searchRequest = new SearchRequest("alexakis_magkas").source(sourceBuilder);
//
//            SearchResponse searchResponse = null;
//
//            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//            List<CourseDTO> courseDTOList = new ArrayList<>();
//            Gson GSON = new Gson();
//            for (SearchHit hit : searchResponse.getHits()) {
//                String source = hit.getSourceAsString();
//                CourseDTO courseDTO = GSON.fromJson(source,CourseDTO.class);
//                courseDTOList.add(courseDTO);
//            }
////            indexRequest.source(new ObjectMapper().writeValueAsString(emp), XContentType.JSON);
//
////        IndexRequest indexRequest = new IndexRequest("sampleindex1");
////        indexRequest.id("003");
////        try {
////            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
////        } catch (JsonProcessingException e) {
////            throw new RuntimeException(e);
////        }
////        IndexResponse indexResponse = null;
////        try {
////            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//        System.out.println("response id: "+indexResponse.getId());
//        System.out.println("response name: "+indexResponse.getResult());
////        System.out.println("response name: "+indexResponse.getResult().name());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return client;
//    }
//}
