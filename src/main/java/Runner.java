import java.util.List;
import java.util.ArrayList;

import com.google.code.stackexchange.common.PagedList;

import com.google.code.stackexchange.client.StackExchangeApiClient;
import com.google.code.stackexchange.client.StackExchangeApiClientFactory;
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
    Long idValue = 483257L;
    
    StackExchangeApiClientFactory factory = StackExchangeApiClientFactory.newInstance(keyValue, StackExchangeSite.fromValue(siteValue));
    StackExchangeApiClient client = factory.createStackExchangeApiClient();
    
    List<Long> userCommentIds = new ArrayList<>();
    List<Comment> userComments = client.getUsersComments(Long.valueOf(idValue));
    for (Comment c : userComments) {
      userCommentIds.add(c.getCommentId());
      //Comment c = client.getComments(uc.getCommentId()).get(0);
      //System.out.println(">" + c.getOwner().getDisplayName() + ":" + c.getBody());
      //System.out.println(uc.getOwner().getDisplayName() + ":" + comment.getCommentId());
    }
    System.out.println(userCommentIds);
    
    client.getComments(Long.valueOf(87327973L));
    
    //PagedList<Comment> comments = 
      //client.getComments(userCommentIds.toArray(new Long[0]));
    
    System.out.println("All done.");
  }

}
                