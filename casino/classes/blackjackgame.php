<?php
    class BlackJackGame extends Game
    {
        public $deck;
        private $playerHand;
        private $dealerHand;

        public function __construct()
        {
            parent::__construct();
        }

        public function newGame()
        {
            $this->deck = new Deck();
            $this->playerHand = new Hand();
            $this->dealerHand = new Hand();
            $this->playerDraw();
            $this->playerDraw();
            $this->dealerDraw();
            $this->dealerDraw();
            $this->saveSession();
        }

        public function saveSession()
        {
            $_SESSION['dealerHand'] = $this->dealerHand;
            $_SESSION['playerHand'] = $this->playerHand;
        }

        public function showPlayerHand()
        {
            $this->playerHand->showHand();
        }

        public function showDealerHand()
        {
            $this->dealerHand->showHand();
        }

        public function showHiddenDealerHand()
        {
            $this->dealerHand->showHiddenDealerHand();
        }

        public function loadSession()
        {
            $this->dealerHand = $_SESSION['dealerHand'];
            $this->playerHand = $_SESSION['playerHand'];
        }

        public function hit()
        {
            $this->loadSession();
            $this->playerDraw();
            $this->saveSession();
        }

        public function endGame()
        {
            while($this->dealerHand->calcHandValue() < 17)
            {
                $this->dealerDraw();
                sleep(2);
            }
            $this->saveSession();
        }

        public function playerDraw()
        {
            $this->draw($this->playerHand);
        }

        public function dealerDraw()
        {
            $this->draw($this->dealerHand);
        }

        private function draw($hand)
        {
            $hand->addCard($this->deck->draw());
        }

        public function getResults()
        {
            $playerScore = $this->playerHand->calcHandValue();
            $dealerScore = $this->dealerHand->calcHandValue();
            $result;
            if($playerScore > "21")
            {
                $result = 'Player Busted. Player loses.';
            }
            else
            {
                if($dealerScore > "21")
                {
                    $result = 'Dealer busted. Player wins!';
                }
                else
                {
                    if($playerScore > $dealerScore)
                    {
                        $result = 'Player hand value is greater. Player wins!';
                    }
                    else if($playerScore == $dealerScore)
                    {
                        $result = 'Draw!';
                    }
                    else
                    {
                        $result = 'Dealer hand value is greater. Player loses.';
                    }
                }
            }
            $html = '<p class= "results">Player Score = '.$playerScore.' Dealer Score = '.$dealerScore.' '.$result.'</p>';
            return $html;
        }
    }
?>