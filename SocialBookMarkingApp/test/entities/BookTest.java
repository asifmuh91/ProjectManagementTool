package entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendlyEligible() {
        //Test 1 : porn in url --false
        Weblink weblink = BookmarkManager.getInstance().createWebLink(2000,"porn.db.com","db.com");
        boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        Assert.assertFalse(isKidFriendlyEligible);
        //test 2: porn in title --false

        //test 3: adult in url, but not in host part -- true
    }
}