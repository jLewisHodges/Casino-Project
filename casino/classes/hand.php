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

        public function showHiddenDealerHand()
        {
            $count=1;
            $basePath = 'images/cards/';
            foreach($this->cards as $card)
            {
                if($count == 1)
                {
                    $class = 'hCard'.$count;
                    echo '<img src="'.$basePath.'purple_back.png" class="'.$class.'">';
                    $count++;
                }
                else
                {
                    $class = 'card'.$count;
                    echo '<img src="'.$card->getImgString($basePath).'" class="'.$class.'">';
                    $count ++;
                }
            }
        }

        //calculates the total value of whats in the players hand
        public function calcHandValue()
        {
            $handValue = 0;
            $aceCount = 0;
            foreach($this->cards as $card)
            {
                if($card->getFace() == 'A')
                {
                    $aceCount++;
                }
                else if(($card->getFace() == 'Q') || ($card->getFace() == 'K') || ($card->getFace() == 'J'))
                {
                    $handValue += 10;
                }
                else
                {
                    $handValue += (int)$card->getFace();
                }
            }
            if($aceCount == 0)
            {
                
            }
            if($aceCount == 1)
            {
                if($handValue <= 10)
                    $handValue += 11;
                else
                    $handValue++;
            }
            else if($aceCount == 2)
            {
                if($handValue <=9)
                    $handValue += 12;
                else
                    $handValue +=2;
            }
            else if($aceCount == 3)
            {
                if($handValue <=8)
                    $handValue +=13;
                else
                    $handValue +=3;
            }
            else
            {
                if($handValue <=7)
                    $handValue +=14;
                else
                    $handValue += 4;
            }
            return $handValue;
        }
    }
?>