package TestK_V;

/**
 * @ClassName BinarySearchTree
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/8 18:44]
 * @Version 1.0
 **/

public class BinarySearchTree {
    private static Node node=null;
    public static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key=key;
        }
    }
    /* *
        * @Author danni
        * @Description :查找
        * @Date 19:00 2019/10/8
        * @Param
        * @return 查找成功：返回该结点，查找失败：返回null
     **/

    public Node search(int key){
        Node cur=node;
        while(cur!=null){
            if(cur.key==key){
                return cur;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
    /* *
        * @Author danni
        * @Description 插入
        * @Date 19:06 2019/10/8
        * @Param [key]
        * @return boolean 插入成功：返回true 插入失败：返回false
     **/
    public boolean insert(int key){
        if(node==null){
            node=new Node(key);
            return true;
        }

        Node cur=node;
        Node parent=null;
        while(cur!=null){
            if(cur.key==key){
                return false;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node temp=new Node(key);
        if(parent.key<key){
            parent.right=temp;
        }else {
            parent.left=temp;
        }
        return true;
    }
    /* *
        * @Author danni
        * @Description:删除
        * @Date 19:07 2019/10/8
        * @Param
        * @return 删除成功：返回true  删除失败：返回false
     **/
    public  boolean remove(int key){
        if(node==null){
            return false;
        }
        Node cur=node;
        Node parent=null;
        while(cur!=null){
            if(cur.key==key){
               this.removeNode(parent,cur);
               return true;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return false;
    }
    private void removeNode(Node parent, Node cur) {
         if(cur.left==null){
            if(cur==node){
                node=cur.right;
            }else if(parent.left==cur){
                parent.left=cur.right;
            }else if(parent.right==cur){
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==node){
                node=cur.left;
            }else if(parent.left==cur){
                parent.left=cur.left;
            }else if(parent.right==cur){
                parent.right=cur.left;
            }
        }else{
            Node goatparent=cur;
            Node goat=cur.right;
            while(goatparent.left!=null){
                goatparent=goat;
                goat=goat.left;
            }
            cur.key=goat.key;
            if(goat==goatparent.left){
               goatparent.left=goat.right;
            }else if(goat==goatparent.right){
                goatparent.right=goat.right;
            }
        }
    }
    public static void inorder(Node node){
       if(node==null){
           return;
       }
       inorder(node.left);
       System.out.print(node.key+",");
       inorder(node.right);
   }

    public static void main(String[] args) {
       BinarySearchTree bst=new BinarySearchTree();
        int[] tree={4,6,2,3,5,8,1,7,9};
        for(int key:tree){
            bst.insert(key);
        }
        inorder(node);
        System.out.println();
        System.out.println(bst.insert(7));
        System.out.println(bst.search(10));
        bst.remove(5);
        inorder(node);
    }
}
