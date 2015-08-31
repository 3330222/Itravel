<!DOCTYPE html>
<html lang="zh-cn">
   <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="Slicebox - 3D Image Slider with Fallback" />
      <meta name="keywords" content="jquery, css3, 3d, webkit, fallback, slider, css3, 3d transforms, slices, rotate, box, automatic" />
      <meta name="author" content="Pedro Botelho for Codrops" />
      <link rel="shortcut icon" href="../favicon.ico">
      <link href="/resource/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
      <link href="/resource/css/button.css" rel="stylesheet" type="text/css" media="all" />
      <link rel="stylesheet" type="text/css" href="/resource/css/slider.css" />
      <link rel="stylesheet" type="text/css" href="/resource/css/slicebox.css" />
      <link rel="stylesheet" type="text/css" href="/resource/css/slidercustom.css" />
      <link rel="stylesheet" href="http://dreamsky.github.io/main/blog/common/init.css">
      <link rel="stylesheet" type="text/css" href="/resource/css/normalize.css" />
      <link rel="stylesheet" type="text/css" href="/resource/css/popup.css" />
      <!-- common styles -->
      <link rel="stylesheet" type="text/css" href="/resource/css/dialog.css" />
      <!-- individual effect -->
      <link rel="stylesheet" type="text/css" href="/resource/css/dialog-wilma.css" />
      <script src="/resource/js/modernizr.custom.js"></script>
      <style>
         .top-banner {
         background-color: rgba(255, 255, 255, 0.55);
         }
         .top-banner a {
         color: #019135;
         }
	
      </style>
      <script type="text/javascript" src="/resource/js/modernizr.custom.46884.js"></script>
   </head>
   <body>
      <div class ="row">
         <div class="col-md-12">
            <!-- <div class="container">-->						
            <div class="wrapper">
               <ul id="sb-slider" class="sb-slider">
                  <li>
                     <a href="" target="_blank"><img src="/resource/image/6.jpg" alt="image1"/></a>
                     
                     <div class="sb">
                        <div class ="row" >
                           <div class ="col-md-4"></div>
                           <div class ="col-md-4"></div>
                        </div>
                     </div>
                  </li>
                  <li>
                     <a href="" target="_blank"><img src="/resource/image/5.jpg" alt="image2"/></a>
                     
                  </li>
                  <li>
                     <a href="" target="_blank"><img src="/resource/image/4.jpg" alt="image1"/></a>
                     
                  </li>
               </ul>               
               <div id="nav-arrows" class="nav-arrows">
                  <a href="#">Next</a>
                  <a href="#">Previous</a>
               </div>
            </div>
            <!-- /wrapper -->			
         </div>
         <!--</div>-->
      </div>
      <script type="text/javascript" src="http://cdn.staticfile.org/jquery/1.8.2/jquery.min.js"></script>	
      <script src="/resource/js/jquery/jquery-1.11.3.js"></script>
      <script type="text/javascript" src="/resource/js/jquery/jquery.slicebox.js"></script>
      <script src="/resource/js/bootstrap.min.js"></script>
      <script type="text/javascript">
          $(function () {

              var Page = (function () {

                  var $navArrows = $('#nav-arrows').hide(),
         			$shadow = $('#shadow').hide(),
         			slicebox = $('#sb-slider').slicebox({
         			    onReady: function () {

         			        $navArrows.show();
         			        $shadow.show();

         			    },
         			    orientation: 'r',
         			    cuboidsRandom: true
         			}),

         			init = function () {

         			    initEvents();

         			},
         			initEvents = function () {

         			    // add navigation events
         			    $navArrows.children(':first').on('click', function () {

         			        slicebox.next();
         			        return false;

         			    });

         			    $navArrows.children(':last').on('click', function () {

         			        slicebox.previous();
         			        return false;

         			    });

         			};

                  return { init: init };

              })();

              Page.init();

          });
      </script>		
   </body>
</html>

