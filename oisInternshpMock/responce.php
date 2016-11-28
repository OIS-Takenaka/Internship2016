<?php

//=========================================
// DEFINE
//=========================================
// カテゴリ一覧パス
define("CATEGORY_FILE_PATH", "./category.csv");
// 商品一覧パス
define("ITEM_FILE_PATH", "./data.csv");

//=========================================
// STATEMENT
//=========================================
// クエリパラメーター
$query = null;

// カテゴリオブジェクト
$categoryRecords = [];
// 商品オブジェクト
$itemRecords = [];

// カテゴリJson
$categoryJson = [];
// 商品Json
$itemJson = [];

//=========================================
// GET TO 
//=========================================
$query = @$_GET['q'];

//=========================================
// GET + ENCODE
//=========================================
// カテゴリcsv取得
$file = new SplFileObject(CATEGORY_FILE_PATH);
$file->setFlags(SplFileObject::READ_CSV);
foreach ($file as $line) $categoryRecords[] = $line;
// カテゴリJSON生成
foreach ($categoryRecords as $key => $line) {
  if($line == [null]) break;
  $tempData = array(
    "id" => $line[0],
    "name" => $line[1],
    "path" => $line[2]
  );
  array_push($categoryJson, $tempData);
}

// 商品csv取得
$file = new SplFileObject(ITEM_FILE_PATH);
$file->setFlags(SplFileObject::READ_CSV);
foreach ($file as $line) $itemRecords[] = $line;
// 商品JSON生成
foreach ($itemRecords as $key => $line) {
  if($line == [null]) break;
  $tempCat = array();
  foreach($categoryRecords as $cat) {
    if($line != [null] && $cat[2] == $line[3]) {
      $tempCat = $cat;
      break;
    }
  }
  $tempData = array(
    "name" => $line[0],
    "price" => $line[1],
    "maker" => $line[2],
    "category" => $line[3],
    "img" => ( $tempCat[2] ."/". $line[4] )
  );
  array_push($itemJson, $tempData);
}

//=========================================
// RETURN
//=========================================
switch($query){
  case "c": print_r(json_encode($categoryJson, JSON_PRETTY_PRINT)); break;
  case "i": print_r(json_encode($itemJson, JSON_PRETTY_PRINT)); break;
  default : echo json_encode("error"); break;
}
?>