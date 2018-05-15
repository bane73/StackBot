import java.util.List;
import java.util.ArrayList;

import com.google.code.stackexchange.common.PagedList;

import com.google.code.stackexchange.client.StackExchangeApiClient;
import com.google.code.stackexchange.client.StackExchangeApiClientFactory;
import com.google.code.stackexchange.client.query.CommentApiQuery;
import com.google.code.stackexchange.client.query.impl.CommentApiQueryImpl;
import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.StackExchangeSite;

public class Runner {
  
  public static void main(String[] args) throws Exception {
    System.out.println("\n\n\n");
    System.out.println("*******************************"); 
    System.out.println("***        StackBot         ***");
    System.out.println("*******************************");
    System.out.println("\n"); 
    
    String keyValue = "PWLEN8DkcLJAbclSsjz1cw((";
    String siteValue = "stackoverflow";
    String accessToken = "be0PQ3cRESzh35NlAUoFCw))";
    
    Long idValue = 483257L; 
    
    StackExchangeApiClientFactory factory = StackExchangeApiClientFactory.newInstance(keyValue, StackExchangeSite.STACK_OVERFLOW);
    StackExchangeApiClient client = factory.createStackExchangeApiClient();
    
    System.out.println("UsersComments:");
    for (Comment c : client.getUsersComments(Long.valueOf(idValue)) ) {      
      String s = "";
      s += "ID: " + c.getCommentId(); 
      s += " ";
      s += "OWNER: " + c.getOwner();
      s += " ";
      s += "BODY: " + c.getBody();
      
      System.out.println(s);
    }
    
    System.out.println("***********");  
    StackExchangeApiQueryFactory queryFactory = StackExchangeApiQueryFactory.newInstance(keyValue, accessToken, StackExchangeSite.STACK_OVERFLOW);
    CommentApiQuery commentApiQuery = queryFactory.newCommentApiQuery().withFilter("withbody");
    PagedList<Comment> comments = commentApiQuery.listMyComments();    
    for (Comment c : comments) { 
      String s = "";
      s += "ID: " + c.getCommentId(); 
      s += " ";
      s += "OWNER: " + c.getOwner();
      s += " ";
      s += "BODY: " + c.getBody();
      
      System.out.println(s);
    }
    
    System.out.println("All done.");
  }

}
                