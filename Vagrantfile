# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  hostname = "duke"
  source_file = "en_US"
  char_map = "UTF-8"

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "ubuntu/trusty64"

  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  config.vm.box_check_update = true

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"
  config.vm.network "private_network", ip: "192.168.59.103"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  config.vm.synced_folder ".", "/src"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.
  config.vm.provider "virtualbox" do |vb|
    vb.memory = 2048
    vb.cpus = 2
  end

  # Define a Vagrant Push strategy for pushing to Atlas. Other push strategies
  # such as FTP and Heroku are also available. See the documentation at
  # https://docs.vagrantup.com/v2/push/atlas.html for more information.
  # config.push.define "atlas" do |push|
  #   push.app = "YOUR_ATLAS_USERNAME/YOUR_APPLICATION_NAME"
  # end

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   sudo apt-get update
  #   sudo apt-get install -y apache2
  # SHELL
  config.vm.provision "shell", inline: <<-SHELL
    # To quiet output: see https://github.com/mitchellh/vagrant/issues/1673
    sed -i 's/^mesg n$/tty -s \\&\\& mesg n/g' /root/.profile

    # to get rid of "dpkg-reconfigure: unable to re-open stdin: No file or directory"
    export DEBIAN_FRONTEND=noninteractive

    touch .hushlogin
    hostname #{hostname}
    localedef -v -c -i #{source_file} -f #{char_map} #{source_file}.#{char_map}

    # tz list in /usr/share/zoneinfo/America/New_York
    sudo rm -f /etc/localtime
    sudo ln -s /usr/share/zoneinfo/America/New_York /etc/localtime

    sudo apt-get update
    #sudo apt-get install -y apache2

    # htop
    apt-get -y -q install software-properties-common htop

    #
    # Install Java 8
    #
    #cd /opt
    #sudo wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u66-b17/jdk-8u66-linux-x64.tar.gz"
    #sudo tar -xzvf jdk-8u66-linux-x64.tar.gz
    #sudo rm -rf jdk-8u66-linux-x64.tar.gz
    apt-get -y -q update
    apt-get -y -q upgrade
    add-apt-repository ppa:webupd8team/java
    apt-get -y -q update
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
    apt-get -y -q install oracle-java8-installer
    #echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
    #apt-get -y -q install oracle-java7-installer
    update-java-alternatives -s java-8-oracle

    #
    # Gradle
    #
    sudo add-apt-repository ppa:cwchien/gradle
    sudo apt-get update
    sudo apt-get -y -q install gradle
    su --command "mkdir ~vagrant/.gradle" vagrant
    touch ~vagrant/.gradle/gradle.properties && echo "org.gradle.daemon=true" >> ~vagrant/.gradle/gradle.properties
  SHELL
  ###config.vm.provision :shell, :path => "vagrant_bootstrap.sh"
end
