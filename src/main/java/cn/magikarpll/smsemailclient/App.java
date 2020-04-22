package cn.magikarpll.smsemailclient;

//import cn.magikarpll.smsemailclient.common.EnableGlobalDispose;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableGlobalDispose
@MapperScan("cn.magikarpll.smsemailclient.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println( "Start Success!" );
    }
}
