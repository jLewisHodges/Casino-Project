<?php 
    if(!class_exists('MasterTemplate'))
    {
        class MasterTemplate
        {
            public function navigation($links_array, $class)
            {
                $nav = '<div class="'.$class.'">
                    <div>
                        <a href="index.php">
                        <img src = "images/logo.png" height = "100" width = "100"></a>
                    </div>
                    ';

                foreach($links_array as $item){
                    $nav .= '<div id="link">
                        <a href="'.$item['url'].'">'.$item['text'].'</a>
                    </div>
                    ';
                }

                return $nav.'
            </div>
                ';
            }
        }
    }

    $dtm = new MasterTemplate;
?>