
// js module
export function formaster() {
    //exports.toolbox = function() { // module in nodejs style
    
      // some sample function - this function will not be exported
        let reverseSimple = function(x){
            console.log(x);
            if((x.value).length<4) {
                x.className = 'invalid';
            }
            else 
                x.className = 'valid';

        };
        
        return {
          validate:function(x){
            if (x.selector) {
              document.querySelectorAll(x.selector).forEach( 
                (element) => {
                    console.log(element);
                  reverseSimple(element);
                }
              );
            } else {
              reverseSimple(x);
            }
          }
        };
      };
    