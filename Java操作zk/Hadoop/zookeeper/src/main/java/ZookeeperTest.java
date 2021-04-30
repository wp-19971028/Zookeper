import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

/**
 * java操作zookeeper客户端对象
 */
public class ZookeeperTest {
    /*
        创建目录操作
     */
    @Test
    public void  createPath() throws Exception {
        String connectString = "node1:2181,node2:2181,node3:2181";
        ExponentialBackoffRetry retrypolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retrypolicy);
        // 启动客户端
        client.start();
        // 修改值
        client.create().withMode(CreateMode.PERSISTENT).forPath("/helloworld");
        client.close();
    }
    @Test
    public void  setData() throws Exception {
        String connectString = "node1:2181,node2:2181,node3:2181";
        ExponentialBackoffRetry retrypolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retrypolicy);
        // 启动客户端
        client.start();
        // 修改值
        client.setData().forPath("/helloworld","albaba".getBytes());
        client.close();
    }
    /**
     * 获取节点的值
     */
    @Test
    public void getData() throws Exception {
        //1.java操作zookeeper客户端对象
        String connectString = "node1:2181,node2:2181,node3:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        //2.启动客户端
        client.start();
        //3.修改值
        byte[] bytes = client.getData().forPath("/helloworld");
        System.out.println(new String(bytes,"utf-8"));
        client.close();
    }
    /**
     * 删除指定节点的数据
     */
    @Test
    public void deletePath() throws Exception {
        //1.java操作zookeeper客户端对象
        String connectString = "node1:2181,node2:2181,node3:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        //2.启动客户端
        client.start();
        //3.删除节点
        client.delete().forPath("/helloworld");
        client.close();
    }


}
