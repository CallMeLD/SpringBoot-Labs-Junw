package my.junw.jlab2.testDemo;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// The @Cleanup annotation is used to automatically close resources, such as streams or connections.
public class CleanupTest {

    /**
     * 使用 @Cleanup 注解处理需要关闭的资源，例如 InputStream、OutputStream、Reader、Writer、Connection 等。
     * 将 @Cleanup 注解放置在局部变量声明上，如例所示。
     * @throws Exception
     */
    @Test
    public void testCleanup() throws Exception {
        @Cleanup InputStream inputStream = new FileInputStream("src/test/resources/example.txt");
        // 使用 inputStream 进行一些操作
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);

        // 确认读取的数据不为空
        assertNotNull(buffer);

        // inputStream 会在这里自动关闭
    }

}
