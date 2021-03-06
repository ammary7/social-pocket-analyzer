package com.ammar.socialpocketa.api;

import com.ammar.socialpocketa.models.CreateTweet;
import com.ammar.socialpocketa.models.LatestReply;
import com.ammar.socialpocketa.models.LoginTwitter;
import com.ammar.socialpocketa.models.Profile;
import com.ammar.socialpocketa.models.RMAnalysisDetail;
import com.ammar.socialpocketa.models.ReplyToTweet;
import com.ammar.socialpocketa.models.TrendDetail;
import com.ammar.socialpocketa.models.TweetDetail;
import com.ammar.socialpocketa.models.Hashtag;
import com.ammar.socialpocketa.models.Login;
import com.ammar.socialpocketa.models.Mention;
import com.ammar.socialpocketa.models.Home;
import com.ammar.socialpocketa.models.Register;
import com.ammar.socialpocketa.models.reply.Reply;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface APIService {

    //The register call
    @FormUrlEncoded
    @POST("api/users/register")
    Call<Register> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password2") String confirmPassword);



    //the login call
    @FormUrlEncoded
    @POST("api/users/login")
    Call<Login> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );


    //the post call
    // defined the Call type as a List and the List type as Home.
    @GET("api/posts")
    Call<List<Home>> getPosts();


    //the comment call
    // defined the Call type as TweetDetail.

    @GET("api/posts/detail/{postId}")
    Call<TweetDetail> getComments(@Path("postId") String postId);
//    @GET("api/posts/detail/5b951359d498032e88f99844")
//    Call<TweetDetail> getComments();


    //the Mentions call
    // defined the Call type as a List and the List type as Mention.
    @GET("api/posts/mentions")
    Call<List<Mention>> getMentions();


    //the Hashtags call
    // defined the Call type as a List and the List type as Hashtag.
    @GET("api/posts/hashtags/{keyword}")
    Call<List<Hashtag>> getHashtagTweets(@Path("keyword") String keyword);


    //the Trends call
    // defined the Call type as a List and the List type as Trend.
    @GET("api/visualization/trends")
    Call<List<TrendDetail>> getTrends();

    //the Profile call
    // defined the Call type as Profile.
    @GET("api/visualization/userinfo")
    Call<Profile> getProfile();


    //the LatestReply call
    // defined the Call type as a List and the List type as LatestReply.
    @GET("api/visualization/latestReplies")
    Call<List<LatestReply>> getLatestReply();


//    the ReplyMentionAnalysisDetail call
    // defined the Call type as ReplyMentionAnalysisDetail
    @GET("api/visualization/replies-mentions-analysis")
//    Call<ReplyMentionAnalysisDetail> getReplyMentionAnalysis();
    Call<RMAnalysisDetail> getReplyMentionAnalysis();


    @FormUrlEncoded
    @POST("api/users/twittertokens")
    Call<LoginTwitter> loginTwitter(
            @Field("user") String user,
            @Field("twitterUsername") String twitterUsername,
            @Field("token") String token,
            @Field("tokenSecret") String tokenSecret
    );



    @FormUrlEncoded
    @POST("api/posts/tweet")
    Call<CreateTweet> createTweet(
            @Field("twtext") String twtext
    );


//    That's how we pass an array in Retrofit

//    @Field("user_uuids[]") ArrayList<String> user_uuids


//    @FormUrlEncoded
//    @POST("api/posts/reply")
//    Call<Reply> replyToTweet(
//
////            @Field("replies[]") Reply[] replies,
//            @Field("replies[]") ArrayList<Reply> replies,
//
////            @Field("replies[]") ArrayList<String> replies,
//            @Field("replyBackText") String replyBackText
//    );



    @FormUrlEncoded
    @POST("api/posts/replyalter")
    Call<ReplyToTweet> replyToTweet(


            @Field("replyBackText") String replyBackText,


            @Field("id_str") ArrayList<String> id_str,


//            @Field("replies[]") Reply[] replies,
            @Field("screenNames") ArrayList<String> screenNames



//            @Field("replies[]") ArrayList<String> replies,

    );



}
