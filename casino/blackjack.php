<?php
require_once('classes/game.php');
require_once('classes/blackjackgame.php');
require_once('classes/deck.php');
require_once('classes/hand.php');

session_start();

$the_title = 'Black Jack';
$script = 'blackjack.js';
include('header.php');

if(!empty($_POST['button']))
{
    $button = $_POST['button'];
}
if(isset($button))
{
    switch($button)
    {
        case 'draw':
            $game = unserialize($_SESSION['newGame']);
            $game->hit();
            $_SESSION['newGame'] = serialize($game);
            break;
        case 'stand':
            $game = new BlackJackGame();
            $game->newGame();
            $_SESSION['newGame'] = serialize($game);
            break;
        case 'surrender':
            $game = new BlackJackGame();
            $game->newGame();
            $_SESSION['newGame'] = serialize($game);
            break; 
        case 'default':
            break;
    }
}
?>

<!--<div class="container dealer">
    <img src = "images/logo.png" height="100px" width="150px">
</div>
<div class="container player">
    <img src = "images/logo.png" height="100px" width="150px">
</div>-->
<div class="container field">
<img src = "images/blackjacktable.jpg" id="table">
    <div class="playerCards">
        <?php 
        if(!empty($game))
            $game->showPlayerHand(); ?>
    </div>
    <form method="post" class="controls" action="">
        <button class="button" name = "button" type="submit" value="draw" id="draw">Draw</button>
        <button class="button" name = "button" type="submit" value="stand" id="stand">Stand</button>
        <button class="button" name = "button" type="submit" value="stand" id="surrender">Surrender</button>
    </form>
</div>
</div>
</div>
<?php include('footer.php');?>