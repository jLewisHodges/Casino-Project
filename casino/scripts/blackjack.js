function endGame(){
    document.getElementById("dealerCards").innerHTML = "'<?php if($endGame == TRUE) { $game = unserialize($_SESSION['newGame']); $game->endGame(); $game->showDealerHand(); $_SESSION['newGame'] = serialize($game); } ?>";
}
