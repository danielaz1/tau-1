//const {toolbox} = require("../js/toolbox.js"); // load module - nodejs style
import {formaster} from '../js/formaster.js';

describe("valid", function () {
    

    const validator = formaster();

    beforeEach(function () {
        //let s = spyOn(console, 'log').and.callThrough();
        let elem = document.createElement('div');
        elem.id = "mycontainer";
        elem.innerHTML = `
        <input type="text" class=pass id="passwordTextField1" value="abc">
        <input type="text" class=pass id="passwordTextField2" value="abcd">
        `;
        document.body.appendChild(elem);
    });

    afterEach(function () {
        $('#mycontainer').remove();
    });

    it("should validate every text - invalid, valid", function () {

        document.getElementById('passwordTextField1').setAttribute('value', 'aaa');
        document.getElementById('passwordTextField2').setAttribute('value', 'aaaa');

        validator.validate({selector: '.pass'});
        
        expect(document.getElementById('passwordTextField1')).toHaveClass('invalid');
        expect(document.getElementById('passwordTextField1')).not.toHaveClass('valid');

        expect(document.getElementById('passwordTextField2')).toHaveClass('valid');
        expect(document.getElementById('passwordTextField2')).not.toHaveClass('invalid');
    });

    it("should validate every text - valid, valid", function () {

        document.getElementById('passwordTextField1').setAttribute('value', 'pass');
        document.getElementById('passwordTextField2').setAttribute('value', 'pass2');

        validator.validate({selector: '.pass'});
        
        expect(document.getElementById('passwordTextField1')).toHaveClass('valid');
        expect(document.getElementById('passwordTextField1')).not.toHaveClass('invalid');

        expect(document.getElementById('passwordTextField2')).toHaveClass('valid');
        expect(document.getElementById('passwordTextField2')).not.toHaveClass('invalid');
    });

    it("should validate every text - invalid, invalid", function () {

        document.getElementById('passwordTextField1').setAttribute('value', '1');
        document.getElementById('passwordTextField2').setAttribute('value', '2');

        validator.validate({selector: '.pass'});
        
        expect(document.getElementById('passwordTextField1')).toHaveClass('invalid');
        expect(document.getElementById('passwordTextField1')).not.toHaveClass('valid');

        expect(document.getElementById('passwordTextField2')).toHaveClass('invalid');
        expect(document.getElementById('passwordTextField2')).not.toHaveClass('valid');
    });

});
