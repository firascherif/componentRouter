<?php
$mail = $_POST["mail"];
echo "votre adresse e-mail est : $mail<br />";
$mailing = (isset($_POST["mailing"])? "oui" : "non");
echo "Avez-vous souhaité vous inscrire sur la lettre d'informations ? $mailing<br />";
$description = htmlentities($_POST["description"],ENT_QUOTES);
echo "et sa description est la suivante : <br />".nl2br($description)."<br />";
$rubrique =  $_POST["rubrique"];
echo "pour la rubrique ".$rubrique;
?>