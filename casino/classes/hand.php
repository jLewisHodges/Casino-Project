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
            $html;
            $count=1;
            $basePath = 'images/cards/';
            foreach($this->cards as $card)
            {
                $class = 'card'.$count;
                echo '<img src="'.$card->getImgString($basePath).'" class="'.$class.'">';
                $count ++;
            }
        }
    }
?>