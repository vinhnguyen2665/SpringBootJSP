Date.prototype.addHours = function (h) {
    this.setTime(this.getTime() + (h * 60 * 60 * 1000));
    return this;
}
Date.prototype.subtract = function (h) {
    this.setTime(this.getTime() - (h * 60 * 60 * 1000));
    return this;
}
Date.prototype.format = function (format) {
    let yearFormat = format.match(/y/g);
    if (!yearFormat) {
        yearFormat = ''
    }
    ;
    let monthFormat = format.match(/M/g);
    if (!monthFormat) {
        monthFormat = ''
    }
    ;
    let dateFormat = format.match(/d/g);
    if (!dateFormat) {
        dateFormat = ''
    }
    ;
    let hourFormat = format.match(/H/g) ? format.match(/H/g) : format.match(/h/g);
    if (!hourFormat) {
        hourFormat = ''
    }
    ;
    let minuteFormat = format.match(/m/g);
    if (!minuteFormat) {
        minuteFormat = ''
    }
    ;
    let secondsFormat = format.match(/s/g);
    if (!secondsFormat) {
        secondsFormat = ''
    }
    ;


    let yearTmp = this.getFullYear().toString();
    let year = yearTmp.substring(yearTmp.length - yearFormat.length, yearTmp.length);

    let monthTmp = (this.getMonth() + 1).toString(); // getMonth() is zero-based
    let month = monthTmp.substring(monthTmp.length - monthFormat.length, monthTmp.length);

    let dateTmp = this.getDate().toString();
    let date = dateTmp.substring(dateTmp.length - dateFormat.length, dateTmp.length);

    let hourTmp = this.getHours().toString();
    let hour = hourTmp.substring(hourTmp.length - hourFormat.length, hourTmp.length);

    let minuteTmp = this.getMinutes().toString();
    let minute = minuteTmp.substring(minuteTmp.length - minuteFormat.length, minuteTmp.length);

    let secondsTmp = this.getSeconds().toString();
    let seconds = secondsTmp.substring(secondsTmp.length - secondsFormat.length, secondsTmp.length);
    if (yearFormat) {
        format = format.replace(yearFormat.toString().replaceAll(',', ''), year)
    }
    if (monthFormat) {
        format = format.replace(monthFormat.toString().replaceAll(',', ''), (month.length == monthFormat.length ? month : "0" + month))
    }
    if (dateFormat) {
        format = format.replace(dateFormat.toString().replaceAll(',', ''), (date.length == dateFormat.length ? date : "0" + date))
    }
    if (hourFormat) {
        format = format.replace(hourFormat.toString().replaceAll(',', ''), (hour.length == hourFormat.length ? hour : "0" + hour))
    }
    if (minuteFormat) {
        format = format.replace(minuteFormat.toString().replaceAll(',', ''), (minute.length == minuteFormat.length ? minute : "0" + minute))
    }
    if (secondsFormat) {
        format = format.replace(secondsFormat.toString().replaceAll(',', ''), (seconds.length == secondsFormat.length ? seconds : "0" + seconds))
    }
    ;
    return format;
    /*
    return (monthFormat? year : '' )
        + (monthFormat? '-' : '') + (month.length == monthFormat.length ? month: "0" + month)
        + (dateFormat? '-' : '') + (date.length == dateFormat.length ? date: "0" + date)
        + (hourFormat? '-' : '') + (hour.length == hourFormat.length ? hour: "0" + hour)
        + (minuteFormat? '-' : '') + (minute.length == minuteFormat.length ? minute: "0" + minute)
        + (secondsFormat? '-' : '') + (seconds.length == secondsFormat.length ? seconds: "0" + seconds);*/
};

function timeConverter(timestamp) {
    let a = new Date(timestamp);
    let months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    let year = a.getFullYear();
    // var month = months[a.getMonth()];
    let month = a.getMonth() + 1;
    let date = a.getDate();
    let hour = a.getHours();
    let min = a.getMinutes();
    let sec = a.getSeconds();
    let time = year + '-' + month.toString().padStart(2, '0') + '-' + date.toString().padStart(2, '0') + ' ' + hour.toString().padStart(2, '0') + ':' + min.toString().padStart(2, '0') + ':' + sec.toString().padStart(2, '0');
    return time;
}

String.prototype.format = String.prototype.f = function () {
    let s = this,
        i = arguments.length;

    while (i--) {
        s = s.replace(new RegExp('\\{' + i + '\\}', 'gm'), arguments[i]);
    }
    return s;
};

function findByValue(fieldName, value, arrayObject) {
    for (let i = 0; i < arrayObject.length; i++) {
        if (value == arrayObject[i][fieldName]) {
            return arrayObject[i];
        }
    }
    ;
    return null;
};

function isExistValue(fieldName, value, arrayObject) {
    for (let i = 0; i < arrayObject.length; i++) {
        if (value == arrayObject[i][fieldName]) {
            return true;
        }
    }
    ;
    return false;
};

function removeFirstItemSatisfy(arr, value) {
    var index = arr.indexOf(value);
    if (index > -1) {
        arr.splice(index, 1);
    }
    return arr;
}

function removeAllItemSatisfy(arr, value) {
    var i = 0;
    while (i < arr.length) {
        if (arr[i] == value) {
            arr.splice(i, 1);
        } else {
            ++i;
        }
    }
    return arr;
}


/*
 * normal = 0;
 * suddenMovement = 1;
 * danger = 2;
 */
function convertFallStatus(status) {
    let str = '';
    switch (status) {
        case 0: {
            str = LAYOUT.normal;
            break;
        }
        case 1: {
            str = LAYOUT.sudden_movement;
            break;
        }
        case 2: {
            str = LAYOUT.danger_of_falling;
            break;
        }
        default: {
            str = '';
        }
    }
    return str;
}
