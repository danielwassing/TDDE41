import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

class ZKNodes
{
    // Method to create znode in zookeeper ensemble
    static void create(String path, byte[] data, ZooKeeper zk) throws KeeperException,InterruptedException
    {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    // Method to check existence of znode and its status, if znode is available.
    static Stat exists(String path, ZooKeeper zk) throws KeeperException,InterruptedException
    {
        return zk.exists(path, true);
    }

    // Method to update the data in a znode.
    static void update(String path, String data_string, ZooKeeper zk) throws KeeperException,InterruptedException
    {
        byte[] data = data_string.getBytes();
        zk.setData(path, data, zk.exists(path,true).getVersion());
    }

    // Method to check existence of znode and its status, if znode is available.
    public static void delete(String path, ZooKeeper zk) throws KeeperException,InterruptedException
    {
        zk.delete(path,zk.exists(path,true).getVersion());
    }
}
