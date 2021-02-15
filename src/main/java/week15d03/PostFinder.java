package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Adott az alábbi osztály:
java
public class Post {
    private String title;
    private LocalDate publishedAt;
    private String content;
    private String owner;
}
Implementáljunk a PostFinder osztályban egy public List<Post> findPostsFor(String user) metódust az alábbi módon:
- Csak olyan Post-ot adjunk vissza, amelynek az owner-e megegyezik a megadott user-rel
- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
- A content és a title nem lehet üres
Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk! (edited)
 */
public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostFor(String user) {
        //    Objects.requireNonNull(user, "user is null"); van valami ilyesmi is a null értékek kezelésére
        List<Post> foundPosts = new ArrayList<>();
        for (Post post : posts) {
            if (!(post.getContent() == null) && !(post.getTitle() == null) && !user.equals(null) && !(post.getPublishedAt() == null) &&
                    !post.getContent().isEmpty() && !post.getTitle().isEmpty() && user.equals(post.getOwner()) && post.getPublishedAt().isBefore(LocalDate.now())) {
                foundPosts.add(post);
            }
        }
        return foundPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "PostFinder{" +
                "posts=" + posts +
                '}';
    }
}
