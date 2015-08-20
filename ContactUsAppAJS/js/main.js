(function ($) {
    $(document).ready(function () {
        jQuery.validator.setDefaults({
            highlight: function (element, errorClass, validClass) {
                if (element.type === "radio") {
                    this.findByName(element.name).addClass(errorClass).removeClass(validClass);
                } else {
                    $(element).closest('.form-group').removeClass('has-success has-feedback').addClass('has-error has-feedback');
                    $(element).closest('.form-group').find('i.fa').remove();
                    $(element).closest('.form-group').append('<i class="fa fa-exclamation fa-lg form-control-feedback"></i>');
                }
            },
            unhighlight: function (element, errorClass, validClass) {
                if (element.type === "radio") {
                    this.findByName(element.name).removeClass(errorClass).addClass(validClass);
                } else {
                    $(element).closest('.form-group').removeClass('has-error has-feedback').addClass('has-success has-feedback');
                    $(element).closest('.form-group').find('i.fa').remove();
                    $(element).closest('.form-group').append('<i class="fa fa-check fa-lg form-control-feedback"></i>');
                }
            }
        });

        $("#contactForm").validate({
            rules: {
					'name': {
                    required: true,
                    minlength: 5,
                    maxlength: 20
                },
                    'email': {
                    required: true,
                    email: true
                },
                    'lastName': {
                    required: true,
                    minlength: 6,
                    maxlength: 25
                },
                    'country': {
                    required: true
                },
					'comments': {
                    required: true,
					minlength: 6,
                    maxlength: 300
                },
				'telephone': {
                    required: false,
					number:true
                },
				'webSite': {
                    required: false,
					url:true
                }
            }
        });
    });
})(jQuery)