<?php
include_once "Banco.php";
$conexao = new Banco('localhost', 'root', '', 'books'  );

// print_r($conexao->execute("INSERT INTO book (author, title, isbn, price ) VALUES ('Sandro Javiel', 'Biografia', '5345367', 34.67);"));

// print_r($conexao->execute("UPDATE book SET author = 'Sandro Caldeira' WHERE price > 30.67;"));
// print_r($conexao->execute("DELETE FROM book WHERE author LIKE '%Sandro Caldeira%';"));
echo "<pre>";
print_r($conexao->execute("SELECT * FROM book;"));
echo "</pre>";

?>