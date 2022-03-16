class Constant {
    static vi = 'vi';
    static en = 'en';
    static ja = 'ja';
    static DATA_TABLE_JA = {
        "emptyTable": "テーブルにデータがありません",
        "info": " _TOTAL_ 件中 _START_ から _END_ まで表示",
        "infoEmpty": " 0 件中 0 から 0 まで表示",
        "infoFiltered": "（全 _MAX_ 件より抽出）",
        "infoThousands": ",",
        "lengthMenu": "_MENU_ 件表示",
        "loadingRecords": "読み込み中...",
        "processing": "<div class=\"spinner-border text-success\" role=\"status\" style=\"z-index:1;margin-top: 10px\"><span class=\"visually-hidden\">処理中...</span></div>",
        "search": "検索:",
        "zeroRecords": "一致するレコードがありません",
        "paginate": {
            "first": "先頭",
            "last": "最終",
            "next": "次",
            "previous": "前"
        },
        "aria": {
            "sortAscending": ": 列を昇順に並べ替えるにはアクティブにする",
            "sortDescending": ": 列を降順に並べ替えるにはアクティブにする"
        }
    }
    static DATA_TABLE_EN = {
        "emptyTable": "No data available in table",
        "info": "Showing _START_ to _END_ of _TOTAL_ entries",
        "infoEmpty": "Showing 0 to 0 of 0 entries",
        "infoFiltered": "(filtered from _MAX_ total entries)",
        "infoThousands": ",",
        "lengthMenu": "Show _MENU_ entries",
        "loadingRecords": "Loading...",
        "processing": "Processing...",
        "search": "Search:",
        "zeroRecords": "No matching records found",
        "thousands": ",",
        "paginate": {
            "first": "First",
            "last": "Last",
            "next": "Next",
            "previous": "Previous"
        },
        "aria": {
            "sortAscending": ": activate to sort column ascending",
            "sortDescending": ": activate to sort column descending"
        },
        "autoFill": {
            "cancel": "Cancel",
            "fill": "Fill all cells with <i>%d</i>",
            "fillHorizontal": "Fill cells horizontally",
            "fillVertical": "Fill cells vertically"
        },
        "buttons": {
            "collection": "Collection <span class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'/>",
            "colvis": "Column Visibility",
            "colvisRestore": "Restore visibility",
            "copy": "Copy",
            "copyKeys": "Press ctrl or u2318 + C to copy the table data to your system clipboard.<br><br>To cancel, click this message or press escape.",
            "copySuccess": {
                "1": "Copied 1 row to clipboard",
                "_": "Copied %d rows to clipboard"
            },
            "copyTitle": "Copy to Clipboard",
            "csv": "CSV",
            "excel": "Excel",
            "pageLength": {
                "-1": "Show all rows",
                "1": "Show 1 row",
                "_": "Show %d rows"
            },
            "pdf": "PDF",
            "print": "Print"
        },
        "searchBuilder": {
            "add": "Add Condition",
            "button": {
                "0": "Search Builder",
                "_": "Search Builder (%d)"
            },
            "clearAll": "Clear All",
            "condition": "Condition",
            "conditions": {
                "date": {
                    "after": "After",
                    "before": "Before",
                    "between": "Between",
                    "empty": "Empty",
                    "equals": "Equals",
                    "not": "Not",
                    "notBetween": "Not Between",
                    "notEmpty": "Not Empty"
                },
                "moment": {
                    "after": "After",
                    "before": "Before",
                    "between": "Between",
                    "empty": "Empty",
                    "equals": "Equals",
                    "not": "Not",
                    "notBetween": "Not Between",
                    "notEmpty": "Not Empty"
                },
                "number": {
                    "between": "Between",
                    "empty": "Empty",
                    "equals": "Equals",
                    "gt": "Greater Than",
                    "gte": "Greater Than Equal To",
                    "lt": "Less Than",
                    "lte": "Less Than Equal To",
                    "not": "Not",
                    "notBetween": "Not Between",
                    "notEmpty": "Not Empty"
                },
                "string": {
                    "contains": "Contains",
                    "empty": "Empty",
                    "endsWith": "Ends With",
                    "equals": "Equals",
                    "not": "Not",
                    "notEmpty": "Not Empty",
                    "startsWith": "Starts With"
                }
            },
            "data": "Data",
            "deleteTitle": "Delete filtering rule",
            "leftTitle": "Outdent Criteria",
            "logicAnd": "And",
            "logicOr": "Or",
            "rightTitle": "Indent Criteria",
            "title": {
                "0": "Search Builder",
                "_": "Search Builder (%d)"
            },
            "value": "Value"
        },
        "searchPanes": {
            "clearMessage": "Clear All",
            "collapse": {
                "0": "SearchPanes",
                "_": "SearchPanes (%d)"
            },
            "count": "{total}",
            "countFiltered": "{shown} ({total})",
            "emptyPanes": "No SearchPanes",
            "loadMessage": "Loading SearchPanes",
            "title": "Filters Active - %d"
        },
        "select": {
            "1": "%d row selected",
            "_": "%d rows selected",
            "cells": {
                "1": "1 cell selected",
                "_": "%d cells selected"
            },
            "columns": {
                "1": "1 column selected",
                "_": "%d columns selected"
            }
        }
    }
    static DATA_TABLE_VI = {
        "sProcessing":   "Đang xử lý...",
        "sLengthMenu":   "Xem _MENU_ mục",
        "sZeroRecords":  "Không tìm thấy dữ liệu phù hợp",
        "sInfo":         "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
        "sInfoEmpty":    "Đang xem 0 đến 0 trong tổng số 0 mục",
        "sInfoFiltered": "(được lọc từ _MAX_ mục)",
        "sSearch":       "Tìm:",
        "oPaginate": {
            "sFirst":    "Đầu",
            "sPrevious": "Trước",
            "sNext":     "Tiếp",
            "sLast":     "Cuối"
        }
    }

    static DATA_TYPE = {
        heart_rate : 'heart-rate',
        step : 'step',
        accelerometer : 'accelerometer',
        gyroscope : 'gyroscope',
        location_gps : 'location-gps',
        fall : 'fall',
    }
    static DATE_FORMAT = {
        yyyyMMddHHmmss: 'yyyy/MM/dd HH:mm:ss',
        yyyyMMddHHmm: 'yyyy/MM/dd HH:mm',
        yyyyMMdd: 'yyyy/MM/dd'
    }

}
