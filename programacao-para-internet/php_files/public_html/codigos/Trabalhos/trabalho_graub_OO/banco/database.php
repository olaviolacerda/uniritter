<?php

mysqli_report(MYSQLI_REPORT_STRICT);
function open_database() {
	try {
		$conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
		return $conn;
	}
	catch (Exception $e) {
		echo $e->getMessage();
		return null;			}
		}

		function close_database($conn) {
			try {
				mysqli_close($conn);
			} catch (Exception $e) {
				echo $e->getMessage();			}		}

				/**
				*  Insere um registro no BD
				*/
				function save($table = null, $data = null) {

					$database = open_database();

					$columns = null;
					$values = null;

					//print_r($data);

					foreach ($data as $key => $value) {
						$columns .= trim($key, "'") . ",";
						$values .= "'$value',";
					}

					// remove a ultima virgula
					$columns = rtrim($columns, ',');
					$values = rtrim($values, ',');

					$sql = "INSERT INTO " . $table . "($columns)" . " VALUES " . "($values);";

					try {
						$database->query($sql);

						$_SESSION['message'] = 'Registro cadastrado com sucesso.';
						$_SESSION['type'] = 'success';

					} catch (Exception $e) {

						$_SESSION['message'] = 'Nao foi possivel realizar a operacao.';
						$_SESSION['type'] = 'danger';
					}

					close_database($database);
				}
