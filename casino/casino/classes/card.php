<?php
    /* author: Jorden Hodges
    */
    class Card{
        public $face;
        public $suit;

        public function getImgString($base_path)
        {
            $path = $base_path . $this->face . $this->suit . '.png';
            return $path;
        }

        public function getFace()
        {
            return $this->face;
        }
}

?>