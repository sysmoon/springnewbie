package studio.moonid.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import studio.moonid.demo.entity.Article;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Transactional(readOnly = true)
//@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 8081)
class ArticleApiControllerTest {

    @Autowired
    private MockMvc mock;

//    @MockBean
//    private ArticleService articleService;

    @Test
    @DisplayName("글 단건 조회")
    void show() throws Exception{
        // given
        final Article articleResponse = new Article(1L, "WFA2.1", "11111");

        // when
        ResultActions act = mock.perform(RestDocumentationRequestBuilders.get("/api/articles/{id}", 1L)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON));

        // then
        act.andExpect(status().isOk());

        // docs
        act.andDo(document("show",
                preprocessRequest(prettyPrint()),   //request json 형식으로 이쁘게 출력
                preprocessResponse(prettyPrint()),  //response json 형식으로 이쁘게 출력
                pathParameters(
                        parameterWithName("id").description("게시글 ID")
                ),
                PayloadDocumentation.responseFields(
                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("게시글 ID"),
                        fieldWithPath("title").type(JsonFieldType.STRING).description("게시글 제목"),
                        fieldWithPath("content").type(JsonFieldType.STRING).description("게시글 내용")
                )
        ));

    }
}