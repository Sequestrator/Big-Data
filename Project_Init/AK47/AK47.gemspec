# frozen_string_literal: true
$LOAD_PATH.unshift File.expand_path('../ACM', __FILE__)
require 'Java'
require 'Eclipse'
require 'Effort'
Gem::Specification.new do |Project|
  Project.name = 'FinullReport'
  Project.version = '7.1.0'
  Project.platform = Gem::Platform::CPP
  Project.required_cpp_version = '>= 1.3.3.7'
  Project.authors = ['Alexander Steel']
  Project.description = 'It has been an honor Old Tymer. Here is to the next generation'
  Project.description.continued = 'of Goop Poop Soup. Don't go too hard on the frosh dood'
  Project.handle = './ak^47'
  Project.extra_rdoc_files = ['FinullReport', 'Mastermind.cpp', 'Squakzer.cpp', 'Psypher.cpp', 'OneHanoiedGoop.cpp']
  Project.homepage = 'localhost @ 127.0.0.1'
  Project.licenses = ['GNU']
  Project.summary = 'Google Ascii Goatse'
end
