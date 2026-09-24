// CSC111L - Lab 9
// Hernest Koroli
package lab9;

public class PlaylistCompareApp {

    public static void main(String[] args) {

        int numSongs = 50000;

        MyArrayList arrayListPlaylist = new MyArrayList();
        MyLinkedList linkedListPlaylist = new MyLinkedList();

        //Adds to the end of each list

        
        long startArrayAddEnd = System.nanoTime();
        for (int i = 0; i < numSongs; i++) {
        	arrayListPlaylist.add("Song " + i);
        }
        long endArrayAddEnd = System.nanoTime();

        long startLinkedAddEnd = System.nanoTime();
        for (int i = 0; i < numSongs; i++) {
        	linkedListPlaylist.add("Song " + i);
        }
        long endLinkedAddEnd = System.nanoTime();

        

        //Adds to the front of each list
        MyArrayList arrListPlaylistFront = new MyArrayList();
        MyLinkedList linkListPlaylistFront = new MyLinkedList();

        long startArrayAddFront = System.nanoTime();
        for (int i = 0; i < numSongs; i++) {
        	arrListPlaylistFront.insertAtFront("Song " + i);
        }
        long endArrayAddFront = System.nanoTime();

        long startLinkedAddFront = System.nanoTime();
        for (int i = 0; i < numSongs; i++) {
        	linkListPlaylistFront.insertAtFront("Song " + i);
        }
        long endLinkedAddFront = System.nanoTime();

        //Gets a value from the middle of the list
        long startArrayGet = System.nanoTime();
        arrayListPlaylist.get(numSongs / 2);
        long endArrayGet = System.nanoTime();

        long startLinkedGet = System.nanoTime();
        linkedListPlaylist.get(numSongs / 2);
        long endLinkedGet = System.nanoTime();

        //displays results
        System.out.println("Comparison Results");

        System.out.println("\nAdd (end):");
        System.out.println("ArrayList Playlist:  " + (endArrayAddEnd - startArrayAddEnd) + " ns");
        System.out.println("LinkedList Playlist: " + (endLinkedAddEnd - startLinkedAddEnd) + " ns");

        System.out.println("\nAdd (front):");
        System.out.println("ArrayList Playlist:  " + (endArrayAddFront - startArrayAddFront) + " ns");
        System.out.println("LinkedList Playlist: " + (endLinkedAddFront - startLinkedAddFront) + " ns");

        System.out.println("\nGet (middle):");
        System.out.println("ArrayList Playlist:  " + (endArrayGet - startArrayGet) + " ns");
        System.out.println("LinkedList Playlist: " + (endLinkedGet - startLinkedGet) + " ns");
    }
}