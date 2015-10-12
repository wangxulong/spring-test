package com.wang;

/**
 * Created by wxl on 2015/10/12.
 */
import com.wang.auth.sys.entity.SysUser;
import com.wang.util.PasswordHelper;
import org.junit.Test;
public class PasswordHelperTest {

    /**
     * username admin
     * password admin123
     * encryptPassword cb14dc935dd4a310593933664a55850e
       salt :ef54d6839ce540dddba8b3e47a731924
     */
    @Test
    public void generatePassword(){
        PasswordHelper passwordHelper =new PasswordHelper();
       /* SysUser user = passwordHelper.md5Password("admin","admin123");
        System.out.println(user.getPassword());
        System.out.println(user.getSalt());*/

        System.out.println(passwordHelper.checkMd5Password("admin","admin123","ef54d6839ce540dddba8b3e47a731924","cb14dc935dd4a310593933664a55850e"));
    }



}
