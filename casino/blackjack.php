<?php 
$the_title = 'Black Jack';
include('header.php');?>

<div class="container dealer">
    <img src = "images/logo.png" height="100px" width="150px">
</div>
<div class="container player">
    <img src = "images/logo.png" height="100px" width="150px">
</div>
<div class="container controls">
    <button class="button" onclick = "drawCard" type="button" id="draw">Draw</button>
    <button class="button" type="button" id="stand">Stand</button>
    <button class="button" type="button" id="surrender">Surrender</button>
</div>
<?php include('footer.php');?>

<?php $the_title = 'Black Jack'; ?>
