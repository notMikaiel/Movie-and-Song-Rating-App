package ratings;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.BinaryTreeNode;


public class Playlist {
    private Comparator<Song> comparator;
    private LinkedListNode<Song> songList;
    private BinaryTreeNode<Song> root;


    public Playlist(Comparator<Song> comparator) {
        this.comparator = comparator;
    }

    public void addSong(Song value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }
    }
    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }
    public LinkedListNode<Song> getSongList() {
        return getSongList(root);
    }
    public BinaryTreeNode<Song> getSongTree(){
        return root;
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> root){
        LinkedListNode<Song> songList = new LinkedListNode<Song>(null, null);
        getSongListHelper(root, songList);
        return songList.getNext();
    }

    private void getSongListHelper(BinaryTreeNode<Song> node, LinkedListNode<Song> songList){
        if (node == null) {
            return;
        }
        getSongListHelper(node.getLeft(), songList);
        songList.append(node.getValue());
        getSongListHelper(node.getRight(), songList);
    }
}
