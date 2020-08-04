
<?php
require('card.php');

class Deck{
    public $cards = array();
    public $faces = array(2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K", "A");
    public $suits = array("d","h","c","s");

    public function __construct()
    {
        foreach($this->faces as $face)
        {
            foreach($this->suits as $suit)
            {
                $card = new Card();
                $card->face = $face;
                $card->suit = $suit;
                
                array_push($this->cards, $card);
            }
        }
        $this->shuffleDeck();
    }

    public function shuffleDeck()
    {
        shuffle($this->cards);
    }

    //grabs card on the top of the deck
    public function draw()
    {
        return array_pop($this->cards);
    }
}

?>