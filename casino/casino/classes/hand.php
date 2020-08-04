<?php
    class Hand
    {
        private $cards = array();

        public function addCard($card)
        {
            array_push($this->cards, $card);
        }

        

        public function showHand()
        {
            $count=1;
            $basePath = 'images/cards/';
            foreach($this->cards as $card)
            {
                $class = 'card'.$count;
                echo '<img src="'.$card->getImgString($basePath).'" class="'.$class.'">';
                $count ++;
            }
        }

        //calculates the total value of whats in the players hand
        public function calcHandValue()
        {
            $handValue = 0;
            foreach($this->cards as $card)
            {
                $handValue += (int)$card->getFace();
            }
            return $handValue;
        }
    }
?>