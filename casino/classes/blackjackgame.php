<?php
    class BlackJackGame extends Game
    {
        public $deck;
        private $playerHand;
        private $computerHand;

        public function __construct()
        {
            parent::__construct();
        }

        public function newGame()
        {
            $this->deck = new Deck();
            $this->playerHand = new Hand();
            $this->computerHand = new Hand();
            $this->playerDraw();
            $this->playerDraw();
            $this->computerDraw();
            $this->computerDraw();
            $this->saveSession();
        }

        public function saveSession()
        {
            $_SESSION['computerHand'] = $this->computerHand;
            $_SESSION['playerHand'] = $this->playerHand;
        }

        public function showPlayerHand()
        {
            $this->playerHand->showHand();
        }

        public function loadSession()
        {
            $this->computerHand = $_SESSION['computerHand'];
            $this->playerHand = $_SESSION['playerHand'];
        }

        public function hit()
        {
            $this->loadSession();
            $this->playerDraw();
            $this->saveSession();
        }

        public function playerDraw()
        {
            $this->draw($this->playerHand);
        }

        public function computerDraw()
        {
            $this->draw($this->computerHand);
        }

        private function draw($hand)
        {
            $hand->addCard($this->deck->draw());
        }
    }
?>