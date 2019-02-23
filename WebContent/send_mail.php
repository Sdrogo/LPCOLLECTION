<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

//Load Composer's autoloader
require 'C:/Windows/System32/vendor/autoload.php';

$nome_mittente = $_POST['nome_mittente'];
$mail_mittente = $_POST['mail_mittente'];
$subject = $_POST['subject'];
$messaggio = $_POST['messaggio'];

$webmaster_email = "andreapartenope@gmail.com";

$mail = new PHPMailer(true);
try{
    $mail->IsHTML(true);
    $mail->IsSMTP();
    $mail->SMTPAuth = true;
    $mail->SMTPSecure = 'tls';
    $mail->Host = 'smtp.gmail.com';
    $mail->Port = 587;
    $mail->Username = 'andreapartenope@gmail.com';
    $mail->Password = ' i80630387 ';
    $mail->SetFrom($webmaster_email);
    $mail->Subject = 'Da : ' . $nome_mittente . ' Mail: ' . $mail_mittente . ' || ' .$subject;
    $mail->Body =  'Da : ' . $nome_mittente . ' Mail: ' . $mail_mittente . ' Messaggio: ' . $messaggio;
    $mail->AddAddress($webmaster_email);
    $mail->send();
    echo 'Messaggio inviato, grazie ' . $nome_mittente . ' per il tuo feedback!';

} catch (Exception $e) {
    echo 'Message could not be sent.';
    echo 'Mailer Error: ' . $mail->ErrorInfo;
}
?>