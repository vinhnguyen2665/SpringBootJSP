class NumberUtils {
    static convert = (hex) => {
        hex = hex.replace("0x","");
        hex = hex.replace("0X","");
        let x = null;
        try {
            x = new BigNumber(hex, 16);
            // document.getElementById("x").style.backgroundColor = "white";
        }
        catch(err) {
            this.log(JSON.stringify(err));
            //document.getElementById("x").style.backgroundColor = "#fff0f0";
            return;
        }
        let xx=x.toString(10);
        this.log("y = " + xx);
        this.log("y3 = " + x.toString(2));
        //	document.getElementById("y").value = xx;
        //	document.getElementById("y3").value = x.toString(2);
        if(this.isInt(x) && x.gte(0) ) {
            if( hex.length==2 && x.gte("80", 16) ) { x=x.minus("100",16); }
            if( hex.length==4 && x.gte("8000", 16) ) { x=x.minus("10000",16); }
            if( hex.length==8 && x.gte("80000000", 16) ) { x=x.minus("100000000",16); }
            let t1 = new BigNumber("8000000000000000",16);
            let t2 = new BigNumber("10000000000000000",16);
            if( hex.length==16 && x.gte(t1) ) { x=x.minus(t2); }
            if( hex.length==2 || hex.length==4 || hex.length==8 || hex.length==16 )
                //document.getElementById("y2").value = x.toString(10);
                this.log("y2=" + x.toString(10));
            else
                this.log("y2=" +"N/A");
            //	document.getElementById("y2").value = "N/A";
        }
        else {
            this.log("y2=" +"N/A");
            //document.getElementById("y2").value = "N/A";
        }

        hex=hex.toUpperCase();
        let txt="("+hex+")\u2081\u2086 = ";
        let d,e,minus=false;
        let len=hex.length;
        if( hex[0]=="-" ) { txt+="-["; hex=hex.substr(1); len--; minus=true; }
        let idot=hex.indexOf(".");
        if( idot>=0 ) { hex=hex.substring(0,idot)+hex.substring(idot+1,len); len--; }
        else idot=len;
        let etbl = ["\u2070","\u00B9","\u00B2","\u00B3","\u2074","\u2075","\u2076","\u2077","\u2078","\u2079"];
        for(let i=0; i<len; i++) {
            d = hex.charCodeAt(i);
            if( d<58 ) d-=48;
            else if( d>64 ) d-=55;
            //e = len-i-1;
            e = idot-i-1;
            e=e.toString();
            txt+="("+d+" \u00D7 16";
            for(let k=0; k<e.length; k++)
                if( e[k]=="-" )
                    txt+="\u207B";
                else
                    txt+=etbl[e[k]];
            txt+=")";
            if( i<len-1 ) txt+=" + ";
        }
        if( minus ) txt+="]";
        txt+=" = ("+xx+")\u2081\u2080";

    }

    static isInt = (value) => {
        let x;
        if (isNaN(value)) {
            return false;
        }
        x = parseFloat(value);
        return (x | 0) === x;
    }

    static log = (log) => {
        console.log(log);
    }
}
