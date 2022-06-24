package facuTesting;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APITestCases implements IAbstractTest {

    @Test(description = "Get posts test")
    @MethodOwner(owner = "Facundo Azcurra")
    public void testGetPosts() {
        GetPostsMethods getPostsMethods = new GetPostsMethods();
        getPostsMethods.callAPIExpectSuccess();
        getPostsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "Get all posts test")
    @MethodOwner(owner = "Facundo Azcurra")
    public void testGetAllPosts() {
        GetAllPostsMethods getAllPostsMethods = new GetAllPostsMethods();
        getAllPostsMethods.callAPIExpectSuccess();
        getAllPostsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "Delete posts method test")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestPriority(Priority.P1)
    public void testDeletePosts() {
        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.setProperties("api/posts/post.properties");
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
    }

    @Test(description = "Post posts method test")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestPriority(Priority.P1)
    public void testPostPosts(){
        PostPostsMethod postPostsMethod = new PostPostsMethod();
        postPostsMethod.callAPIExpectSuccess();
        postPostsMethod.validateResponse();
    }

    @Test(description = "Patch posts method test")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestPriority(Priority.P1)
    public void testPatchPost(){
        PatchPostsMethod patchPostsMethod = new PatchPostsMethod();
        patchPostsMethod.callAPIExpectSuccess();
        patchPostsMethod.validateResponse();
    }


}
